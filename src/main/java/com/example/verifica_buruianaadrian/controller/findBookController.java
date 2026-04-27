package com.example.verifica_buruianaadrian.controller;

import com.example.verifica_buruianaadrian.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class findBookController {
    @FXML
    public TextArea textArea;
    @FXML
    public RadioButton oTitolo;
    @FXML
    public RadioButton oPos;
    @FXML
    public RadioButton oISBN;

    Biblioteca biblioteca = DataStore.biblioteca;

    public void initialize(){
        ToggleGroup gruppo = new ToggleGroup();
        oISBN.setToggleGroup(gruppo);
        oPos.setToggleGroup(gruppo);
        oTitolo.setToggleGroup(gruppo);
        ordinamentoPerTitolo();
    }
    public void tornaMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/verifica_buruianaadrian/menu.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void ordinamentoPerTitolo(){
        ArrayList<Libro> ordinamento = new ArrayList<>(biblioteca.getListalibri());
        Collections.sort(ordinamento, new ComparatorTitolo());
        textArea.clear();
        for(Libro l : ordinamento){
            textArea.appendText(l.toString() + "\n");
        }
    }

    public void ordinamentoPerISBN(){
        ArrayList<Libro> ordinamento = new ArrayList<>(biblioteca.getListalibri());
        Collections.sort(ordinamento, new ComparatorISBN());
        textArea.clear();
        for(Libro l : ordinamento){
            textArea.appendText(l.toString() + "\n");
        }
    }

    public void ordinamentoPosizione(){
        ArrayList<Libro> ordinamento = new ArrayList<>(biblioteca.getListalibri());
        Collections.sort(ordinamento, new ComparatorPosizione());
        textArea.clear();
        for(Libro l : ordinamento){
            textArea.appendText(l.toString() + "\n");
        }
    }
}
