package com.example.isoplanificadorprocesos;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PPController {

    private PPService pp_service = new PPService();

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onMaterialTestButtonClick() {
        welcomeText.setText("Cargando procesos");
        pp_service.loadProcesos();
    }
}