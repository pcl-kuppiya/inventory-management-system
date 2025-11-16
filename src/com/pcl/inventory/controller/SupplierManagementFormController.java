package com.pcl.inventory.controller;

import com.pcl.inventory.bo.BoFactory;
import com.pcl.inventory.bo.custom.SupplierBo;
import com.pcl.inventory.dto.request.RequestSupplierDto;
import com.pcl.inventory.dto.response.ResponseSupplierDto;
import com.pcl.inventory.utill.BoType;
import com.pcl.inventory.view.tm.SupplierTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

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
    public TableView<SupplierTm> tblSupplier;
    public TableColumn<SupplierTm,String> colId;
    public TableColumn <SupplierTm,String>  colName;
    public TableColumn <SupplierTm,String>  colContactPerson;
    public TableColumn <SupplierTm,String>  colPhone;
    public TableColumn <SupplierTm,String>  colEmail;
    public TableColumn <SupplierTm,String>  colAddress1;
    public TableColumn <SupplierTm,String>  colAddress2;
    public TableColumn <SupplierTm,String>  colCity;
    public TableColumn <SupplierTm,String>  colCountry;
    public TableColumn <SupplierTm,Button>  colAction;
    public Button btnSave;
    public String search="";

    SupplierBo supplierBo= BoFactory.getInstance().getBoFactory(BoType.SUPPLIER);
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactPerson.setCellValueFactory(new PropertyValueFactory<>("contactPerson"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress1.setCellValueFactory(new PropertyValueFactory<>("address1"));
        colAddress2.setCellValueFactory(new PropertyValueFactory<>("address2"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            this.search=newValue;
            setSupplierTableData(search);
        });
        tblSupplier.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setDataToInputFields((SupplierTm)newValue);
            }
        });
        setSupplierId();
        setSupplierTableData(search);
    }

    private void setDataToInputFields(SupplierTm newValue) {
        btnSave.setText("Update");
        txtId.setText(newValue.getId());
        txtName.setText(newValue.getName());
        txtContactPerson.setText(newValue.getContactPerson());
        txtContactNumber.setText(newValue.getContactNumber());
        txtEmail.setText(newValue.getEmail());
        txtAddress1.setText(newValue.getAddress1());
        txtAddress2.setText(newValue.getAddress2());
        txtCity.setText(newValue.getCity());
        txtCountry.setText(newValue.getCountry());

    }

    private void setSupplierTableData(String search) {
        try {
            List<ResponseSupplierDto> suppliersByName = supplierBo.getSuppliersByName(search);
            ObservableList<SupplierTm> supplierObList = FXCollections.observableArrayList();

            for (ResponseSupplierDto dto:suppliersByName){
                Button btnDelete=new Button("Delete");
                supplierObList.add(new SupplierTm(
                        dto.getId(),
                        dto.getName(),
                        dto.getContactPerson(),
                        dto.getContactNumber(),
                        dto.getEmail(),
                        dto.getAddress1(),
                        dto.getAddress2(),
                        dto.getCity(),
                        dto.getCountry(),
                        btnDelete
                ));
                btnDelete.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure...", ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult()==ButtonType.YES) {
                        try {
                            boolean isDeleted = supplierBo.delete(dto.getId());
                            if (isDeleted) {
                                setSupplierId();
                                setSupplierTableData(search);
                            }
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
            tblSupplier.setItems(supplierObList);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setSupplierId() {
        try {
            String supplierId = supplierBo.getSupplierId();
            txtId.setText(supplierId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveOnAction(ActionEvent actionEvent) {
        try {
            if (btnSave.getText().equals("Save")) {
                boolean isSaved = supplierBo.create(new RequestSupplierDto(
                        txtId.getText(),
                        txtName.getText(),
                        txtContactPerson.getText(),
                        txtContactNumber.getText(),
                        txtEmail.getText(),
                        txtAddress1.getText(),
                        txtAddress2.getText(),
                        txtCity.getText(),
                        txtCountry.getText()
                ));
                if (isSaved) {
                    new Alert(Alert.AlertType.INFORMATION,"Supplier Saved").show();
                    clearFileds();
                    setSupplierId();
                    setSupplierTableData(search);

                }
            }else {
                boolean isUpdated = supplierBo.update(new RequestSupplierDto(
                        txtId.getText(),
                        txtName.getText(),
                        txtContactPerson.getText(),
                        txtContactNumber.getText(),
                        txtEmail.getText(),
                        txtAddress1.getText(),
                        txtAddress2.getText(),
                        txtCity.getText(),
                        txtCountry.getText()
                ));
                if (isUpdated) {
                    clearFileds();
                    setSupplierTableData(search);
                    setSupplierId();
                    btnSave.setText("Save");
                    new Alert(Alert.AlertType.INFORMATION,"Supplier Updated").show();

                }
            }
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void clearFileds() {
        txtName.clear();
        txtContactPerson.clear();
        txtContactNumber.clear();
        txtEmail.clear();
        txtAddress1.clear();
        txtAddress2.clear();
        txtCity.clear();
        txtCountry.clear();
    }
}
