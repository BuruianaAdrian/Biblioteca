package com.example.verifica_buruianaadrian.model;

import java.util.Comparator;
import java.util.Objects;

public class ComparatorISBN implements Comparator<Libro> {
    @Override
    public int compare(Libro a, Libro b){
        return a.getCodiceISBN().compareTo(b.getCodiceISBN());
    }
}
