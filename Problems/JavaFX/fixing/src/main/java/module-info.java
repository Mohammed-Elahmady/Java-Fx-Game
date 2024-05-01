module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens com.example.project to javafx.fxml;
    exports com.example.project;
    exports Learning;
    opens Learning to javafx.fxml;
}