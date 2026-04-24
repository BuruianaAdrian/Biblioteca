package com.example.verifica_buruianaadrian.controller;

import com.example.verifica_buruianaadrian.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class addBooksController {

    @FXML
    private void cambiaScena(ActionEvent event) throws IOException {
        // 1. Carica il nuovo file FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/verifica_buruianaadrian/menu.fxml"));
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
    public TextField ISBN;
    @FXML
    public ComboBox<Scaffale> boxScaffale;
    @FXML
    public ComboBox<Integer> boxPiano;
    @FXML
    public TextArea textArea;
    @FXML
    public Button bISBN;
    @FXML
    public Button titolo;
    @FXML
    public Button posizione;
    public int lol;

    ArrayList<Scaffale> listScaffali;
    ArrayList<Libro> listLibri;
    Biblioteca biblioteca = new Biblioteca();

    public void initialize(){
        listScaffali = new ArrayList<>();
        listLibri = new ArrayList<>();

        Scaffale scaffale1 = new Scaffale("1AE4R", 1);
        listScaffali.add(scaffale1);
        Scaffale scaffale2 = new Scaffale("67UO2", 2);
        listScaffali.add(scaffale2);
        Scaffale scaffale3 = new Scaffale("T3ET5", 3);
        listScaffali.add(scaffale3);


        Libro libro1 = new Libro("12345", "Tommy's advanture", "Tommy", "tlou");
        listLibri.add(libro1);
        Libro libro2 = new Libro("123456", "The suffering of Joel", "Joel", "tlou");
        listLibri.add(libro2);
        Libro libro3 = new Libro("1234567", "Ellie's suffering", "Ellie", "tlou");
        listLibri.add(libro3);

        biblioteca.setListalibri(listLibri);
        biblioteca.setListascaffale(listScaffali);

        boxScaffale.getItems().addAll(listScaffali);

        for(Scaffale a: listScaffali){
            boxPiano.getItems().add(a.getPiano());
        }
    }


    public void mostraTextArea(String risultato){
        textArea.clear();
        textArea.setText(risultato);
    }

    public void assegna(){
        String ISBN1 = ISBN.getText();
        Libro libro = biblioteca.controlloCodice(ISBN1);
        if(libro == null) {
            textArea.setText("Codice sbagliato");
        }else if(libro.isPosizionato(libro)){
            textArea.setText("Libro gia posizionato");
        }else{
            Integer piano = boxPiano.getValue();
            Scaffale scaffale = boxScaffale.getValue();
            if(piano == null || scaffale == null){
                mostraTextArea("Errore:Inserisci scaffale e piano");
            }else{
                libro.setNumeroPiano(piano);
                libro.setScaffale(scaffale);

                mostraTextArea(libro.toString());
            }
        }
    }
    public void ordinamentoPerTitolo(){
        ArrayList<Libro> ordinamento = new ArrayList<>(listLibri);
        Collections.sort(ordinamento, new ComparatorTitolo());
        textArea.clear();
        for(Libro l : ordinamento){
            textArea.appendText(l.toString() + "\n");
        }
    }

    public void ordinamentoPerISBN(){
        ArrayList<Libro> ordinamento = new ArrayList<>(listLibri);
        Collections.sort(ordinamento, new ComparatorISBN());
        textArea.clear();
        for(Libro l : ordinamento){
            textArea.appendText(l.toString() + "\n");
        }
    }

    public void ordinamentoPosizione(){
        ArrayList<Libro> ordinamento = new ArrayList<>(listLibri);
        Collections.sort(ordinamento, new ComparatorPosizione());
        textArea.clear();
        for(Libro l : ordinamento){
            textArea.appendText(l.toString() + "\n");
        }
    }


}