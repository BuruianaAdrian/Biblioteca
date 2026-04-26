package com.example.verifica_buruianaadrian.controller;

import com.example.verifica_buruianaadrian.model.Biblioteca;
import com.example.verifica_buruianaadrian.model.DataStore;
import com.example.verifica_buruianaadrian.model.Libro;
import com.example.verifica_buruianaadrian.model.Scaffale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class modifyPosController {
    @FXML
    public Label messageLabel;
    @FXML
    public ComboBox <Scaffale> inputScaffale;
    @FXML
    public ComboBox <Integer> inputPiano;
    @FXML
    public TextField inputISBN;

    Biblioteca biblioteca = DataStore.biblioteca;

    public void initialize(){
        inputScaffale.getItems().addAll(biblioteca.getListascaffale());

        for(Scaffale a: biblioteca.getListascaffale()){
            inputPiano.getItems().add(a.getPiano());
        }
    }
    @FXML
    public void tornaMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/verifica_buruianaadrian/menu.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void aggiornaLibro(String ISBN, Integer piano, Scaffale scaffale){
        Libro libro = null;
        for(Libro a: biblioteca.getListalibri()){
            if(a.getCodiceISBN().equals(ISBN)){
                libro = a;
            }
        }
        libro.setScaffale(scaffale);
        libro.setNumeroPiano(piano);
    }

    public void conferma(){
        String ISBN = inputISBN.getText();
        Integer piano = inputPiano.getValue();
        Scaffale scaffale = inputScaffale.getValue();

        if(biblioteca.controlloCodice(ISBN)){
            aggiornaLibro(ISBN, piano, scaffale);
            messageLabel.setVisible(true);
            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("Libro modificato con successo.");
        }else{
            messageLabel.setVisible(true);
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Libro non registrato.");
        }
    }
}
