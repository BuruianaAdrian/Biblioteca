package com.example.verifica_buruianaadrian.model;

public class Scaffale {
    private String codice;
    private int piano;

    public Scaffale(String codice, int piano) {
        this.codice = codice;
        this.piano = piano;
    }

    @Override
    public String toString() {
        return codice;
    }

    public String getCodice() {
        return codice;
    }

    public int getPiano() {
        return piano;
    }
}
