package com.pcl.inventory.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SupplierManagementFormController {
    public TextField txtSearch;
    public TextField txtId;
    public TextField txtName;
    public TextField txtContactPerson;
    public TextField txtContactNumber;
    public TextField txtEmail;
    public TextField txtAddress1;
    public TextField txtAddress2;
    public TextField txtCity;
    public TextField txtCountry;
    public TableView tblSupplier;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colContactPerson;
    public TableColumn colPhone;
    public TableColumn colEmail;
    public TableColumn colAddress1;
    public TableColumn colAddress2;
    public TableColumn colCity;
    public TableColumn colCountry;
    public TableColumn colAction;

    public void saveOnAction(ActionEvent actionEvent) {
    }
}
