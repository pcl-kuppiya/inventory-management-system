package com.pcl.inventory.controller;

import com.pcl.inventory.bo.BoFactory;
import com.pcl.inventory.bo.custom.CategoryBo;
import com.pcl.inventory.dto.request.RequestCategoryDto;
import com.pcl.inventory.utill.BoType;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class CategoryManagementFormController {

    public TextField txtSearch;
    public TextField txtId;
    public TextField txtName;
    public TextField txtDescription;
    public Button btnSave;
    CategoryBo categoryBo= BoFactory.getInstance().getBoFactory(BoType.CATEGORY);
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
