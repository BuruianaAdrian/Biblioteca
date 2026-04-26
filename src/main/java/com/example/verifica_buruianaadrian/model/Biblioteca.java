package com.example.verifica_buruianaadrian.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca{
    ArrayList<Libro> listalibri;
    ArrayList<Scaffale> listascaffale;

    public Biblioteca() {
        this.listalibri = new ArrayList<>();
        this.listascaffale = new ArrayList<>();

        Scaffale scaffale1 = new Scaffale("1AE4R", 1);
        listascaffale.add(scaffale1);
        Scaffale scaffale2 = new Scaffale("67UO2", 2);
        listascaffale.add(scaffale2);
        Scaffale scaffale3 = new Scaffale("T3ET5", 3);
        listascaffale.add(scaffale3);
    }
    public boolean controlloCodice(String codiceISBN){
        for(Libro a : listalibri){
            if(a.getCodiceISBN().equals(codiceISBN)){
                return true;
            }
        }
        return false;
    }
    public void setListalibri(ArrayList<Libro> listalibri) {
        this.listalibri = listalibri;
    }

    public void setListascaffale(ArrayList<Scaffale> listascaffale) {
        this.listascaffale = listascaffale;
    }

    public ArrayList<Libro> getListalibri() {
        return listalibri;
    }

    public ArrayList<Scaffale> getListascaffale() {
        return listascaffale;
    }
}
