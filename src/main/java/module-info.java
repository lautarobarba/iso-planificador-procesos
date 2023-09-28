module com.example.isoplanificadorprocesos {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.isoplanificadorprocesos to javafx.fxml;
    exports com.example.isoplanificadorprocesos;
}