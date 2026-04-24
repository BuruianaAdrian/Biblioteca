package com.example.verifica_buruianaadrian.model;

import java.util.Comparator;

public class ComparatorTitolo implements Comparator<Libro> {
    @Override
    public int compare(Libro a, Libro b) {
        return a.getTitolo().compareTo(b.getTitolo());
    }
}
