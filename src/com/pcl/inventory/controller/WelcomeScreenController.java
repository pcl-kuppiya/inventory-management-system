package com.pcl.inventory.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class WelcomeScreenController {
    public AnchorPane context;

    public void navigateLoginOnAction(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm");
    }

    public void navigateSignupOnAction(ActionEvent actionEvent) throws IOException {
        setUI("SignUpForm");
    }

    private void setUI(String location) throws IOException {
        Stage stage =(Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/pcl/inventory/view/"+location+".fxml"))));
    }

}
