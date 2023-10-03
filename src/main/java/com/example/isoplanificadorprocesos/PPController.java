package com.example.isoplanificadorprocesos;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class PPController implements Initializable {
    private PPService pp_service = new PPService();

    //@FXML
    //private ListView<Proceso> listProcesos = new ListView<Proceso>();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        pp_service.loadProcesos();
        for(Proceso proc_aux :this.pp_service.getProcesos()) {
            //listProcesos.getItems().add(proc_aux);
        }
    }
    @FXML
    protected void onBtnCargarProcesosClick() {

    }
}