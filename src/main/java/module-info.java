module com.example.verifica_buruianaadrian {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.verifica_buruianaadrian to javafx.fxml;
    exports com.example.verifica_buruianaadrian;
    exports com.example.verifica_buruianaadrian.controller;
    opens com.example.verifica_buruianaadrian.controller to javafx.fxml;
}