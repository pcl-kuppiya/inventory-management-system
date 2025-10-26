package com.pcl.inventory.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class AdminPanelController {
    public AnchorPane context;
    public AnchorPane mainContext;

    public void initialize() throws IOException {
        setChildUi("Dashboard");
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) mainContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/pcl/inventory/view/LoginForm.fxml"))));

    }
    public void openOrderFormOnAction(ActionEvent actionEvent) throws IOException {
        setChildUi("OrderManagementForm");

    }

    public void openDashboardFormOnAction(ActionEvent actionEvent) throws IOException {
        setChildUi("Dashboard");

    }



    public void openProductFormOnAction(ActionEvent actionEvent) throws IOException {
        setChildUi("ProductsManagementForm");
    }

    public void openCategoryFormOnAction(ActionEvent actionEvent) throws IOException {
        setChildUi("CategoryManagementForm");
    }

    public void openSupplierFormOnAction(ActionEvent actionEvent) throws IOException {
        setChildUi("SupplierManagementForm");
    }

    public void openCustomerFormOnAction(ActionEvent actionEvent) throws IOException {
        setChildUi("CustomerManagementForm");
    }

    public void openReportFormOnAction(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.ERROR,"404 Reports not found").show();
    }
    private void setChildUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(
                FXMLLoader.load(getClass().getResource("/com/pcl/inventory/view/"+location+".fxml"))
        );
    }
}
