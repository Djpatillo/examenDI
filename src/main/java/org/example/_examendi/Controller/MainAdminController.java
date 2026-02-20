package org.example._examendi.Controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example._examendi.DAO.VideojuegoDAO;
import org.example._examendi.Modelo.Videojuego;
import org.example._examendi.utils.AppShell;

import java.util.Date;

public class MainAdminController {

    @FXML
    TextField titulo;
    @FXML
    CheckBox completado;
    @FXML
    DatePicker fecha;

    @FXML
    TableView<Videojuego> tablaVideojuegos;
    @FXML
    TableColumn<Videojuego, String> colTitulo;
    @FXML
    TableColumn<Videojuego, Boolean> colCompletado;
    @FXML
    TableColumn<Videojuego, Date> colFecha;

    public void initialize() {
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colCompletado.setCellValueFactory(new PropertyValueFactory<>("completado"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaLanzamiento"));

        cargarDatos();
    }

    private void cargarDatos() {
        tablaVideojuegos.setItems(FXCollections.observableArrayList(VideojuegoDAO.obtenerTodos()));
    }

    public void handleFavorito(ActionEvent actionEvent) {
        Videojuego seleccionado = tablaVideojuegos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            String user = AppShell.getInstance().getUsuarioLogueado().getUsername();
            VideojuegoDAO.marcarFavorito(user, seleccionado.getTitulo());
        }
    }

    public void hanldeAnadir(ActionEvent actionEvent) {
        if (titulo.getText() != null && fecha.getValue() != null) {
            VideojuegoDAO.anadirVideojuego(titulo.getText(), completado.isSelected(), fecha.getValue());
            cargarDatos();
            limpiarCampos();
        }
    }

    public void handleEliminar(ActionEvent actionEvent) {
        Videojuego seleccionado = tablaVideojuegos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            VideojuegoDAO.eliminarVideojuego(seleccionado.getTitulo());
            cargarDatos();
        }
    }

    private void limpiarCampos() {
        titulo.clear();
        completado.setSelected(false);
        fecha.setValue(null);
    }
}