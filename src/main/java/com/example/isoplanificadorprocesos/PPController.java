package com.example.isoplanificadorprocesos;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PPController implements Initializable {
    private PPService pp_service = new PPService();

    @FXML
    private Label labelListaProcesos;
    @FXML
    private Label labelPoliticaEjecucion;
    @FXML
    private TableView<Proceso> tableListaProcesos;
    @FXML
    private TableColumn<Proceso, Number> columnID;
    @FXML
    private TableColumn<Proceso, String> columnNombre;
    @FXML
    private TableColumn<Proceso, Number> columnTiempoArribo;
    @FXML
    private TableColumn<Proceso, Number> columnCantidadRafagas;
    @FXML
    private TableColumn<Proceso, Number> columnDuracionRafagaCPU;
    @FXML
    private TableColumn<Proceso, Number> columnDuracionRafagaIO;
    @FXML
    private TableColumn<Proceso, Number> columnPrioridad;

    ObservableList<Proceso> listaProcesos = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> comboPoliticasEjecucion;
    ObservableList<String> opcionesPoliticasEjecucion = FXCollections.observableArrayList(
            "FCFS (First Come First Served)",
            "PE (Prioridad Externa)",
            "RR (Round-Robin)",
            "SPN (Shortest Process Next)",
            "SRTN (Shortest Remaining Time Next)"
    );

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        // Inicializo tabla de procesos:
        columnID.setCellValueFactory(new PropertyValueFactory<Proceso, Number>("id"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<Proceso, String>("nombre"));
        columnTiempoArribo.setCellValueFactory(new PropertyValueFactory<Proceso, Number>("tiempoArribo"));
        columnCantidadRafagas.setCellValueFactory(new PropertyValueFactory<Proceso, Number>("cantidadRafagas"));
        columnDuracionRafagaCPU.setCellValueFactory(new PropertyValueFactory<Proceso, Number>("duracionRafagaCPU"));
        columnDuracionRafagaIO.setCellValueFactory(new PropertyValueFactory<Proceso, Number>("duracionRafagaIO"));
        columnPrioridad.setCellValueFactory(new PropertyValueFactory<Proceso, Number>("prioridad"));

        // Cargo los procesos en la tabla
        pp_service.loadProcesos();
        for(Proceso proc_aux :this.pp_service.getProcesos()) {
            listaProcesos.add(proc_aux);
        }
        tableListaProcesos.setItems(listaProcesos);


        // Inicializo comboBox con las políticas de ejecución disponibles
        comboPoliticasEjecucion.setItems(opcionesPoliticasEjecucion);
    }
    @FXML
    protected void onBtnEjecutarTandaDeProcesosClick() {

    }

    @FXML
    protected void onComboBoxListaPoliticasSelect(Event event) {

    }
}