package org.example._examendi.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.example._examendi.Modelo.Usuario;

import java.net.URL;

public class AppShell {
    private static AppShell instance;
    private static Stage primaryStage;

    private Usuario usuarioLogueado;

    public static AppShell getInstance() {
        if (instance == null) {
            instance = new AppShell();
        }
        return instance;
    }
    public void initialize(Stage stage) {
        primaryStage = stage;

    }
    public void loadView(String fxml){
        URL url = getClass().getResource(fxml);
        try{
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            primaryStage.setScene(new javafx.scene.Scene(root));
            primaryStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setUsuarioLogueado() {

    }
    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }


}

