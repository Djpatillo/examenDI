package org.example._examendi.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example._examendi.DAO.UsuarioDAO;
import org.example._examendi.utils.AppShell;

public class LoginController {
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    Label labelError;

    public void handleLogin(ActionEvent actionEvent) {
        if(username.getText().isEmpty() || password.getText().isEmpty()){
            System.out.println("Faltan datos");
        }
        if(username.getText().equals("admin") && password.getText().equals("admin")){
            AppShell.getInstance().setUsuarioLogueado();
            AppShell.getInstance().loadView("/mainAdmin-view.fxml");

        }

        if(UsuarioDAO.validarCredenciales(username, password).equals(true)){
            AppShell.getInstance().setUsuarioLogueado();
            AppShell.getInstance().loadView("/main-view.fxml");
        }else {
            System.out.println("Credenciales incorrectas");
            labelError.setText("Credenciales incorrectas");

        }
    }

    public void handleRegistrarse(ActionEvent actionEvent) {
        AppShell.getInstance().loadView("/org/example/_examendi/registro-view.fxml");

    }
}
