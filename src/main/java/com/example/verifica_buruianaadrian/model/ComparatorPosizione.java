package com.example.verifica_buruianaadrian.model;

import java.util.Comparator;
import java.util.Objects;

public class ComparatorPosizione implements Comparator<Libro> {
    @Override
    public int compare(Libro a , Libro b){
        if(a.isPosizionato(a) == true && b.isPosizionato(b) == true){
            if(a.getScaffale()!=b.getScaffale()){
                return CharSequence.compare(a.getScaffale().getCodice(), b.getScaffale().getCodice());
            }else{
                return Integer.compare(a.getScaffale().getPiano(), b.getScaffale().getPiano());
            }
        }else if(a.isPosizionato(a) == false && b.isPosizionato(b) == false){
            if(!Objects.equals(a.getCodiceISBN(), b.getCodiceISBN())){
                return CharSequence.compare(a.getCodiceISBN(), b.getCodiceISBN());
            }
        }else{
            return Integer.compare(a.getNumeroPiano(), b.getNumeroPiano());
        }
        return 0;
    }
}
