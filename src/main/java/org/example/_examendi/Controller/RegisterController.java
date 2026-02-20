package org.example._examendi.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example._examendi.DAO.UsuarioDAO;
import org.example._examendi.utils.AppShell;

public class RegisterController {

    @FXML
    TextField usernameRegistro;
    @FXML
    PasswordField passwordRegistro1;
    @FXML
    PasswordField passwordRegistro2;

    @FXML
    Label errorLabel;

    public void handleRegistrarse(ActionEvent actionEvent) {
        if(passwordRegistro1.getText().isEmpty() || passwordRegistro2.getText().isEmpty()){
            System.out.println("Faltan datos");
        }
        if(passwordRegistro1.getText().equals(passwordRegistro2.getText())){
            UsuarioDAO.registrarUsuario(usernameRegistro, passwordRegistro1);
            AppShell.getInstance().loadView("/login-view.fxml");
        }else {
            System.out.println("Las contraseñas no coinciden");
            errorLabel.setText("Las contraseñas no coinciden");

        }

}


}
