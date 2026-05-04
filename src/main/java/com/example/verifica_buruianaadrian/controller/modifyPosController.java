package com.example.verifica_buruianaadrian.controller;

import com.example.verifica_buruianaadrian.model.*;
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
    @FXML
    public ComboBox<Categoria> inputCategoria;

    Biblioteca biblioteca = DataStore.biblioteca;

    public void initialize(){
        inputScaffale.getItems().addAll(biblioteca.getListascaffale());
        inputCategoria.getItems().addAll(Categoria.values());

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

    public void aggiornaLibro(String ISBN, Integer piano, Scaffale scaffale, Categoria categoria){
        Libro libro = null;
        for(Libro a: biblioteca.getListalibri()){
            if(a.getCodiceISBN().equals(ISBN)){
                libro = a;
            }
        }

        if(libro == null) return;

        if(piano != null && scaffale != null){
            libro.setNumeroPiano(piano);
            libro.setScaffale(scaffale);
        }
        if(categoria != null){
            libro.setCategoria(categoria);
        }

    }


    public void conferma(){
        String ISBN = inputISBN.getText();
        Integer piano = inputPiano.getValue();
        Scaffale scaffale = inputScaffale.getValue();
        Categoria categoria = inputCategoria.getValue();

        boolean conCategoria = piano != null && scaffale != null && categoria != null;
        boolean senzaCategoria = piano != null && scaffale != null && categoria == null;
        boolean soloCategoria = piano == null && scaffale == null && categoria != null;

        if(biblioteca.controlloCodice(ISBN)){
            if(senzaCategoria){
                aggiornaLibro(ISBN, piano,scaffale,null);
                showSuccess("Piano e scaffale modificato con successo");
            } else if (conCategoria) {
                aggiornaLibro(ISBN, piano, scaffale, categoria);
                showSuccess("Piano, scaffale e categoria modificato con successo");
            }
            if(soloCategoria){
                aggiornaLibro(ISBN, null, null, categoria);
                showSuccess("Categoria modificato con successo");
            }

        }else{
            showError("Libro non registrato.");
        }
    }

    public void showSuccess(String s){
        messageLabel.setVisible(true);
        messageLabel.setStyle("-fx-text-fill: green;");
        messageLabel.setText(s);
    }
    public void showError(String s){
        messageLabel.setVisible(true);
        messageLabel.setStyle("-fx-text-fill: red;");
        messageLabel.setText(s);
    }

}
