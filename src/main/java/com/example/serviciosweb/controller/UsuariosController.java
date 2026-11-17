package com.example.serviciosweb.controller;

import com.example.serviciosweb.model.Usuario;
import com.example.serviciosweb.service.UsuarioService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class UsuariosController {

    @FXML
    private Button btnConsultar;

    @FXML
    private TableColumn<Usuario, String> colCiudad;

    @FXML
    private TableColumn<Usuario, String> colCorreo;

    @FXML
    private TableColumn<Usuario, String> colEmpresa;

    @FXML
    private TableColumn<Usuario, Integer> colId;

    @FXML
    private TableColumn<Usuario, String> colNombre;

    @FXML
    private TableColumn<Usuario, String> colTelefono;

    @FXML
    private TableColumn<Usuario, String> colUsername;

    @FXML
    private TableView<Usuario> tblUsuarios;

    private final UsuarioService servicio = new UsuarioService();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));
    }

    @FXML
    void consultar(ActionEvent event) {
        try {
            List<Usuario> usuarios = servicio.obtenerUsuarios();
            tblUsuarios.setItems(FXCollections.observableArrayList(usuarios));
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("No se pudo consultar los usuarios");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
    }

}
