package com.example.verifica_buruianaadrian.model;

import java.util.Comparator;
import java.util.Objects;

public class ComparatorPosizione implements Comparator<Libro> {
    @Override
    // 1. Confronta i codici degli Scaffali se sono diversi restituisce l'ordine alfabetico dei codici
    // 2. Se lo scaffale è lo stesso, confronta i piani
    public int compare(Libro a , Libro b){
        if (!a.getScaffale().getCodice().equals(b.getScaffale().getCodice())) {
            return a.getScaffale().getCodice().compareTo(b.getScaffale().getCodice());
        }

        return Integer.compare(a.getScaffale().getPiano(), b.getScaffale().getPiano());
    }
}
