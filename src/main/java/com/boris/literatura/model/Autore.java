package com.boris.literatura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaFallecimieto;
    @OneToMany(mappedBy = "autore", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libro;

    public Autore() {}

    public Autore(DatosAutores datosAutores) {
        this.nombre = datosAutores.nombre();
        this.fechaNacimiento = datosAutores.añoNacimiento();
        this.fechaFallecimieto = datosAutores.añoFallecimiento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaFallecimieto() {
        return fechaFallecimieto;
    }

    public void setFechaFallecimieto(Integer fechaFallecimieto) {
        this.fechaFallecimieto = fechaFallecimieto;
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaFallecimieto=" + fechaFallecimieto;
    }
}
