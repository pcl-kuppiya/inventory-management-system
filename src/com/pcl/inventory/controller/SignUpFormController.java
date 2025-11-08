package com.pcl.inventory.controller;

import com.pcl.inventory.bo.BoFactory;
import com.pcl.inventory.bo.custom.UserBo;
import com.pcl.inventory.dto.request.RequestUserDto;
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

public class SignUpFormController {
    public AnchorPane context;
    public TextField txtEmail;
    public PasswordField txtPassword;
    public TextField txtDisplayName;
    public TextField txtContactNumber;
    UserBo userBo=BoFactory.getInstance().getBoFactory(BoType.USER);
    public void navigateLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }

    public void signupOnAction(ActionEvent actionEvent) throws IOException {

        try {
            boolean isSaved = userBo.registerUser(
                    new RequestUserDto(txtEmail.getText(),
                            txtDisplayName.getText(),
                            txtContactNumber.getText(), txtPassword.getText()));
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "User registered successfully!").show();
                setUi("LoginForm");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    private void setUi(String location) throws IOException {
        Stage stage =(Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/pcl/inventory/view/"+location+".fxml"))));
    }
}
