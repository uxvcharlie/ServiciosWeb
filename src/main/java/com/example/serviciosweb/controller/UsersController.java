package com.example.serviciosweb.controller;

import com.example.serviciosweb.model.Users;
import com.example.serviciosweb.service.UsersService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class UsersController {

    @FXML
    private Button btnConsultar;

    @FXML
    private TableColumn<Users, String> colApellido;

    @FXML
    private TableColumn<Users, String> colCiudad;

    @FXML
    private TableColumn<Users, String> colCorreo;

    @FXML
    private TableColumn<Users, LocalDate> colCreado;

    @FXML
    private TableColumn<Users, String> colDeuda;

    @FXML
    private TableColumn<Users, String> colEstado;

    @FXML
    private TableColumn<Users, Integer> colId;

    @FXML
    private TableColumn<Users, Float> colIngreso;

    @FXML
    private TableColumn<Users, String> colMonto;

    @FXML
    private TableColumn<Users, String> colNombre;

    @FXML
    private TableColumn<Users, Integer> colScore;

    @FXML
    private TableColumn<Users, String> colTelefono;

    @FXML
    private TableView<Users> tblUsers;

    private final UsersService servicio = new UsersService();

    public void initialize() {
        configurarTablas();
    }

    @FXML
    void consultar() {
        try {
            tblUsers.setItems(FXCollections.observableArrayList(servicio.obtenerUsuarios()));
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("No se pudo consultar los usuarios");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
    }

    public void configurarTablas() {
        colId.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getId()));
        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFirstName()));
        colApellido.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLastName()));
        colCorreo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmail()));
        colTelefono.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPhone()));
        colCiudad.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCity()));
        colIngreso.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getAnnualIncome()));
        colScore.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getCreditScore()));
        colDeuda.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().isHasUnpaidDebt() ? "Sí" : "No"));
        colMonto.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getUnpaidDebtAmount()));
        colEstado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));
        colCreado.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getCreatedAt()));
    }
}
