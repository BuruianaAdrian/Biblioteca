package com.example.verifica_buruianaadrian.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class menuController {
    @FXML
    private void scenaAddBooks(ActionEvent event) throws IOException {
        // 1. Carica il nuovo file FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/verifica_buruianaadrian/addBooks.fxml"));
        Parent root = loader.load();

        // 2. Ottieni lo Stage (la finestra) attuale.
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // 3. Crea la nuova scena con il file caricato
        Scene scene = new Scene(root);

        // 4. Imposta la scena sullo stage e mostrala
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void scenaModifca(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/verifica_buruianaadrian/modifyPos.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
