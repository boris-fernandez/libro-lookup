package com.boris.literatura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autore autore;
    private String idioma;
    private Integer totalDescarga;

    public Libro(){}
    public Libro(DatosLibros datosLibros) {
        this.titulo = datosLibros.titulo();
        this.idioma = datosLibros.idiomas().get(0);
        this.autore = new Autore(datosLibros.autores().get(0));
        this.totalDescarga = datosLibros.totalDescarga();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autore getAutores() {
        return autore;
    }

    public void setAutores(Autore autore) {
        this.autore = autore;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getTotalDescarga() {
        return totalDescarga;
    }

    public void setTotalDescarga(Integer totalDescarga) {
        this.totalDescarga = totalDescarga;
    }

    @Override
    public String toString() {
        return  "------------------------------------------\n" +
                "titulo= " + titulo + '\n' +
                "autore= " + autore + '\n' +
                "idiomas= " + idioma + '\n' +
                "totalDescarga= " + totalDescarga;
    }
}
