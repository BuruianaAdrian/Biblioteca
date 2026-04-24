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
    }
    public Libro controlloCodice(String codiceISBN){
        for(Libro a : listalibri){
            if(codiceISBN.equals(a.getCodiceISBN())){
                return a;
            }
        }
        return null;
    }
    public void setListalibri(ArrayList<Libro> listalibri) {
        this.listalibri = listalibri;
    }

    public void setListascaffale(ArrayList<Scaffale> listascaffale) {
        this.listascaffale = listascaffale;
    }



}
