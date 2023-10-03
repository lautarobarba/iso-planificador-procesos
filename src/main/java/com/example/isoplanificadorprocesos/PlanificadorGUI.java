package com.example.isoplanificadorprocesos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PlanificadorGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PlanificadorGUI.class.getResource("planificador-gui.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Integrador - Planificador de procesos");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}