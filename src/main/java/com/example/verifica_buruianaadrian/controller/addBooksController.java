package com.example.verifica_buruianaadrian.controller;

import com.example.verifica_buruianaadrian.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class addBooksController {
    @FXML
    public TextField ISBNi;
    @FXML
    public ComboBox<Scaffale> boxScaffaleI;
    @FXML
    public ComboBox<Integer> boxPianoI;
    @FXML
    public TextField titoloI;
    @FXML
    public TextField autoreI;
    @FXML
    public TextField editoreI;
    @FXML
    public Label messageLabel;
    @FXML
    public ComboBox<Categoria> boxCategoria;

    Biblioteca biblioteca = DataStore.biblioteca;

    public void initialize(){
        ArrayList<Libro> listLibri = new ArrayList<>();
        ArrayList<Scaffale> listScaffale = new ArrayList<>();

        listScaffale.add(new Scaffale("1AE4R", 8));
        listScaffale.add(new Scaffale("67UO2", 9));
        listScaffale.add(new Scaffale("T3ET5", 5));

        biblioteca.setListascaffale(listScaffale);
        biblioteca.setListalibri(listLibri);

        boxScaffaleI.getItems().addAll(listScaffale);
        boxCategoria.getItems().addAll(Categoria.values());

        boxScaffaleI.getSelectionModel().selectFirst();
        loadPiani();
    }
    @FXML
    public void loadPiani(){
        boxPianoI.getItems().clear();
        Scaffale s = boxScaffaleI.getValue();
        for(int i = 1; i <= s.getPiano(); i++){
            boxPianoI.getItems().add(i);
        }
    }

    @FXML
    public void tornaMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/verifica_buruianaadrian/menu.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void conferma(){
        String ISBN = ISBNi.getText();
        String titolo = titoloI.getText();
        String autore = autoreI.getText();
        String editore = editoreI.getText();
        Categoria categoria = boxCategoria.getValue();

        Integer piano = boxPianoI.getValue();
        Scaffale scaffale = boxScaffaleI.getValue();

        boolean posizioneVuota = piano == null && scaffale == null && categoria == null;
        boolean posizioneCompleta = piano != null && scaffale != null && categoria != null;

        if(ISBN.isEmpty() || titolo.isEmpty() || autore.isEmpty() || editore.isEmpty() || (!posizioneVuota && !posizioneCompleta)){
            showError("Compila tutti i campi, se vuoi posizionare un libro scegli piano, scaffale e categoria.");
            return;
        }
        if(biblioteca.controlloCodice(ISBN)){
            showError("ISBN già esistente");
            return;
        }

        Libro libro;
        if(posizioneVuota){
            libro = new Libro(ISBN,titolo,autore,editore);
            biblioteca.getListalibri().add(libro);
            showSuccess("Libro aggiunto con successo");
        }else{
            libro = new Libro(ISBN,titolo,autore,editore);
            libro.setNumeroPiano(piano);
            libro.setScaffale(scaffale);
            libro.setCategoria(categoria);
            biblioteca.getListalibri().add(libro);
            showSuccess("Libro aggiunto con successo");
        }

        for(Libro a : biblioteca.getListalibri()){
            System.out.println(a.getCodiceISBN());
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