package org.example._examendi;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example._examendi.utils.AppShell;

public class MainApp extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        AppShell.getInstance().initialize(stage);
        AppShell.getInstance().loadView("/org/example/_examendi/login-view.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
