package org.example._examendi.Controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example._examendi.DAO.VideojuegoDAO;
import org.example._examendi.Modelo.Videojuego;
import org.example._examendi.utils.AppShell;

import java.util.Date;

public class MainController {
    @FXML
    TableView<Videojuego> tablaVideojuegos;
    @FXML
    TableColumn<Videojuego, String> colTitulo;
    @FXML
    TableColumn<Videojuego, Boolean> colCompletado;
    @FXML
    TableColumn<Videojuego, Date> colFecha;


    public void initialize(){
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colCompletado.setCellValueFactory(new PropertyValueFactory<>("completado"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaLanzamiento"));

        tablaVideojuegos.setItems(FXCollections.observableArrayList(VideojuegoDAO.obtenerTodos()));
    }

    public void handleFavorito(ActionEvent actionEvent) {
        Videojuego seleccionado = tablaVideojuegos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            String user = AppShell.getInstance().getUsuarioLogueado().getUsername();
            VideojuegoDAO.marcarFavorito(user, seleccionado.getTitulo());
        }
    }
}
