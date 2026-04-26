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

    Biblioteca biblioteca = DataStore.biblioteca;

    public void initialize(){
        boxPianoI.getItems().clear();
        boxScaffaleI.getItems().clear();

        boxScaffaleI.getItems().addAll(biblioteca.getListascaffale());

        for(Scaffale a: biblioteca.getListascaffale()){
            boxPianoI.getItems().add(a.getPiano());
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

        Integer piano = boxPianoI.getValue();
        Scaffale scaffale = boxScaffaleI.getValue();
        if(ISBN.isEmpty() || titolo.isEmpty() || autore.isEmpty() || editore.isEmpty() || piano == null || scaffale == null){
            messageLabel.setVisible(true);
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Compila tutti i campi");
            return;
        }
        if(biblioteca.controlloCodice(ISBN)){
            messageLabel.setVisible(true);
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("ISBN già esistente");
            return;
        }
        Libro libro = new Libro(ISBN,titolo,autore,editore);
        libro.setNumeroPiano(piano);
        libro.setScaffale(scaffale);

        biblioteca.getListalibri().add(libro);

        messageLabel.setVisible(true);
        messageLabel.setStyle("-fx-text-fill: green;");
        messageLabel.setText("Libro aggiunto con successo");

        for( Libro a : biblioteca.getListalibri()){
            System.out.println(a.getCodiceISBN());
        }
    }
//    public void ordinamentoPerTitolo(){
//        ArrayList<Libro> ordinamento = new ArrayList<>(listLibri);
//        Collections.sort(ordinamento, new ComparatorTitolo());
//        textArea.clear();
//        for(Libro l : ordinamento){
//            textArea.appendText(l.toString() + "\n");
//        }
//    }
//
//    public void ordinamentoPerISBN(){
//        ArrayList<Libro> ordinamento = new ArrayList<>(listLibri);
//        Collections.sort(ordinamento, new ComparatorISBN());
//        textArea.clear();
//        for(Libro l : ordinamento){
//            textArea.appendText(l.toString() + "\n");
//        }
//    }
//
//    public void ordinamentoPosizione(){
//        ArrayList<Libro> ordinamento = new ArrayList<>(listLibri);
//        Collections.sort(ordinamento, new ComparatorPosizione());
//        textArea.clear();
//        for(Libro l : ordinamento){
//            textArea.appendText(l.toString() + "\n");
//        }
//    }


}