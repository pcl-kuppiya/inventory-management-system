package com.pcl.inventory.controller;

import com.pcl.inventory.bo.BoFactory;
import com.pcl.inventory.bo.custom.ProductBo;
import com.pcl.inventory.utill.BoType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ProductsManagementFormController {

    public TextField txtSearchByName;
    public ComboBox cmbFilterByCat;
    public ComboBox cmbFilterBySupplier;
    public TextField txtId;
    public TextField txtName;
    public TextField txtDescription;
    public ComboBox cmbCategory;
    public ComboBox cmbSupplier;
    public TextField txtUnitPrice;
    public TextField txtStock;
    public TextField txtUser;

    ProductBo productBo= BoFactory.getInstance().getBoFactory(BoType.PRODUCT);
    public void initialize(){
        setProdId();
    }

    private void setProdId() {
        try {
            txtId.setText(productBo.getLastProductID());

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
