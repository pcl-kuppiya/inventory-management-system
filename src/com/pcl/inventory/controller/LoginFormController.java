package com.pcl.inventory.controller;

import com.pcl.inventory.bo.BoFactory;
import com.pcl.inventory.bo.custom.UserBo;
import com.pcl.inventory.dto.response.ResponseUserDto;
import com.pcl.inventory.utill.BoType;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public AnchorPane context;
    public TextField txtEmail;
    public PasswordField txtPassowrd;
    UserBo userBo= BoFactory.getInstance().getBoFactory(BoType.USER);
    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        try {
            ResponseUserDto responseLogin = userBo.login(txtEmail.getText(), txtPassowrd.getText());
            if (responseLogin != null) {
                if (responseLogin.getStatusCode().equals("200")) {
                    setUi("AdminPanel");
                    new Alert(Alert.AlertType.INFORMATION,"Welocme : "+responseLogin.getName()).show();

                }else {
                    new Alert(Alert.AlertType.WARNING,"Incorrect Password").show();
                }
            }else {
                new Alert(Alert.AlertType.ERROR,"User not found").show();
            }


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

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
