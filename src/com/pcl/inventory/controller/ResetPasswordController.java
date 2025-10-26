package com.pcl.inventory.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ResetPasswordController {
    public AnchorPane context;

    public void resetPasswordOnAction(ActionEvent actionEvent) throws IOException {
        //check both fields and update password
        setUi("LoginForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage =(Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/pcl/inventory/view/"+location+".fxml"))));
    }
}
