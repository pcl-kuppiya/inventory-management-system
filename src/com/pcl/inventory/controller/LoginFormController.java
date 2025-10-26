package com.pcl.inventory.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane context;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        //login implementtation
        setUi("AdminPanel");
    }

    public void navigateSignUpOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignUpForm");
    }

    public void navigateForgotPasswordOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ForgotPassword");
    }
    private void setUi(String location) throws IOException {
        Stage stage =(Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/pcl/inventory/view/"+location+".fxml"))));
    }
}
