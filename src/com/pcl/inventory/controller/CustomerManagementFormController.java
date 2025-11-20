package com.pcl.inventory.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CustomerManagementFormController {
    public TextField txtId;
    public TextField txtFName;
    public TextField txtLName;
    public TextField txtContact;
    public TextField txtAddress1;
    public TextField txtAddress2;
    public TextField txtSearch;
    public TextField txtCity;
    public TextField txtEmail;
    public Button btnSave;
    public TableView tblCustomer;
    public TableColumn colId;
    public TableColumn colFName;
    public TableColumn colLName;
    public TableColumn colEmail;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colAddress2;
    public TableColumn colCity;
    public TableColumn colAction;

    public void saveOnAction(ActionEvent actionEvent) {

    }
}
