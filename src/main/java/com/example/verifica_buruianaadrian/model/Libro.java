package com.example.verifica_buruianaadrian.model;

public class Libro implements Comparable<Libro>{
    private String codiceISBN;
    private String titolo;
    private String autore;
    private String editore;
    private Scaffale scaffale;
    private int numeroPiano;

    public Libro(String codiceISBN, String titolo, String autore, String editore) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.editore = editore;
    }
    public int compareTo(Libro libro){
        return this.titolo.compareTo(libro.titolo);
    }

    @Override
    public String toString() {
        return  "---------------------------\n"+
                "CodiceISBN: " + codiceISBN +
                ", Titolo: " + titolo +"\n"+
                "Autore: " + autore +
                ", Editore: " + editore + "\n"+
                "Scaffale: " + scaffale +
                ", NumeroPiano: " + numeroPiano + "\n" +
                "---------------------------\n";
    }
    public Boolean isPosizionato(Libro a){
        if(a.getNumeroPiano() != 0){
            return true;
        }
        return false;
    }
    public String getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getEditore() {
        return editore;
    }

    public int getNumeroPiano() {
        return numeroPiano;
    }

    public void setCodiceISBN(String codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setEditore(String editore) {
        this.editore = editore;
    }

    public void setScaffale(Scaffale scaffale) {
        this.scaffale = scaffale;
    }

    public void setNumeroPiano(int numeroPiano) {
        this.numeroPiano = numeroPiano;
    }

    public Scaffale getScaffale() {
        return scaffale;
    }
}
