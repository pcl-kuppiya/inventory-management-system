package com.pcl.inventory.controller;

import com.pcl.inventory.bo.BoFactory;
import com.pcl.inventory.bo.custom.ProductBo;
import com.pcl.inventory.dto.request.RequestProductDto;
import com.pcl.inventory.dto.response.ResponseCategoryDto;
import com.pcl.inventory.utill.BoType;
import com.pcl.inventory.utill.tools.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.List;

public class ProductsManagementFormController {

    public TextField txtSearchByName;
    public ComboBox cmbFilterByCat;
    public ComboBox cmbFilterBySupplier;
    public TextField txtId;
    public TextField txtName;
    public TextField txtDescription;
    public ComboBox<String> cmbCategory;
    public ComboBox<String> cmbSupplier;
    public TextField txtUnitPrice;
    public TextField txtStock;
    public TextField txtUser;
    public Button btnSave;

    ProductBo productBo= BoFactory.getInstance().getBoFactory(BoType.PRODUCT);
    public void initialize(){
        setProdId();
        setCmbCategoryList();
        setCmbSupplierList();
        setUserData();



    }

    private void setUserData() {
        txtUser.setText(Session.getLoggedUserId());
    }

    private void setCmbSupplierList() {
        try {
            List<String> allSuppliers = productBo.getAllSuppliers();
            ObservableList<String> suppliersOblist = FXCollections.observableArrayList(allSuppliers);

            cmbSupplier.setItems(suppliersOblist);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCmbCategoryList() {
        try {
            List<ResponseCategoryDto> allCategories = productBo.getAllCategories();
            ObservableList<String> catObList= FXCollections.observableArrayList();

            for (ResponseCategoryDto category : allCategories) {
                catObList.add(category.getCategoryId()+" - "+category.getCategoryName());
            }
            cmbCategory.setItems(catObList);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setProdId() {
        try {
            txtId.setText(productBo.getLastProductID());

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveOnAction(ActionEvent actionEvent) {
        try {
            if (btnSave.getText().equals("Save")) {
                boolean isCreated = productBo.createProduct(new RequestProductDto(
                        txtId.getText(),
                        txtName.getText(),
                        Double.parseDouble(txtUnitPrice.getText()),
                        Integer.parseInt(txtStock.getText()),
                        txtDescription.getText(),
                        cmbCategory.getValue(),
                        Session.getLoggedUserId(),
                        cmbSupplier.getValue()
                ));
                if (isCreated) {
                    new Alert(Alert.AlertType.INFORMATION,"Product Created").show();
                }
            }else {

            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
