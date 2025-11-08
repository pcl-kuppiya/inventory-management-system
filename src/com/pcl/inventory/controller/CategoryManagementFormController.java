package com.pcl.inventory.controller;

import com.pcl.inventory.bo.BoFactory;
import com.pcl.inventory.bo.custom.CategoryBo;
import com.pcl.inventory.dto.request.RequestCategoryDto;
import com.pcl.inventory.dto.response.ResponseCategoryDto;
import com.pcl.inventory.utill.BoType;
import com.pcl.inventory.view.tm.CategoryTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class CategoryManagementFormController {

    public TextField txtSearch;
    public TextField txtId;
    public TextField txtName;
    public TextField txtDescription;
    public Button btnSave;
    public TableView<CategoryTm> tblCategory;
    public TableColumn<CategoryTm,String> colId;
    public TableColumn <CategoryTm,String>  colName;
    public TableColumn <CategoryTm,String>  colDescription;
    public TableColumn <CategoryTm,Button>colAction;
    CategoryBo categoryBo= BoFactory.getInstance().getBoFactory(BoType.CATEGORY);
    String searchText="";

    public void initialize() throws SQLException, ClassNotFoundException {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
        setTableData(searchText);
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            this.searchText=newValue;
            try {
                setTableData(searchText);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        });

        try {
            setCategoryId();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void setTableData(String searchText) throws SQLException, ClassNotFoundException {
        List<ResponseCategoryDto> categoryList = categoryBo.getCategoryByName(searchText);
        ObservableList<CategoryTm> categoryObList= FXCollections.observableArrayList();

        for (ResponseCategoryDto cat:categoryList){
            Button btnDelete=new Button("Delete");
            categoryObList.add(new CategoryTm(
                    cat.getCategoryId(),
                    cat.getCategoryName(),
                    cat.getDescription(),
                    btnDelete
            ));


        }
        tblCategory.setItems(categoryObList);

    }

    private void setCategoryId() throws SQLException, ClassNotFoundException {
        String categoryId = categoryBo.getCategoryId();
        txtId.setText(categoryId);
    }

    public void saveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("Save")) {
            try {
                boolean isSaved = categoryBo.saveCategory(
                        new RequestCategoryDto(
                                txtId.getText(),
                                txtName.getText(),
                                txtDescription.getText()
                        )
                );
                if (isSaved) {
                    setCategoryId();
                    setTableData(searchText);
                    new Alert(Alert.AlertType.INFORMATION,"Category has been saved successfully!").show();
                }
            }catch (ClassNotFoundException| SQLException e){
                e.printStackTrace();
            }

        }else {
            //update
        }
    }
}
