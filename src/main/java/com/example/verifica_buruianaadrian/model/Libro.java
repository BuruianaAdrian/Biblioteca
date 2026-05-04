package com.example.verifica_buruianaadrian.model;

public class Libro implements Comparable<Libro>{
    private String codiceISBN;
    private String titolo;
    private String autore;
    private String editore;
    private Categoria categoria;
    private Scaffale scaffale;
    private int numeroPiano;
    private Categoria categoria;

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
                "NumeroPiano: " + (numeroPiano == 0 ? "non posizionato" : numeroPiano) +
                ", Scaffale: " +(scaffale == null ? "non posizionato" : scaffale) + "\n" +
                "Categoria: " + (categoria == null ? "non posizionato" : categoria ) + "\n" +
                "---------------------------\n";
    }
    public Boolean isPosizionato(){
        return this.scaffale != null && this.numeroPiano != 0;
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
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

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
