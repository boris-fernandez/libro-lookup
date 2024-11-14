package com.boris.literatura.main;

import com.boris.literatura.model.*;
import com.boris.literatura.repository.AutorRepository;
import com.boris.literatura.repository.LibroRepository;
import com.boris.literatura.service.ConsumoAPI;
import com.boris.literatura.service.ConvertirDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Principal {
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private Scanner teclado = new Scanner(System.in);
    private ConvertirDatos conversor = new ConvertirDatos();
    private static String URL_BASE = "https://gutendex.com/books/?";
    private List<DatosLibros> datosLibros = new ArrayList<>();
    private List<Libro> libros;
    private List<Autore> autores;
    private LibroRepository repositoryLibro;
    private AutorRepository repositoryAutor;

    public Principal(LibroRepository repositoryLibro, AutorRepository repositoryAutor) {
        this.repositoryLibro = repositoryLibro;
        this.repositoryAutor = repositoryAutor;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    ==============================================
                                 Literatura - Alura
                    ==============================================
                    1 - Agregar libro por nombre
                    2 - buscar por autor
                    3 - Lista de libros registrados
                    4 - Lista de autores registrados
                    5 - Lista de libros por idioma
                    
                    0 - Salir
                    ==============================================
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    AgregarLibro();
                    break;
                case 2:
                    buscarAutorPorLibro();
                    break;
                case 3:
                    mostrarLibroBuscado();
                    break;
                case 4:
                    mostrarAutorBuscado();
                    break;
                case 5:
                    mostrarListaPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private DatosLibros DatosLibros() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        String nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "+") );
        Datos datos = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> optionalDatosLibros = datos.libros().stream()
                .filter(b -> b.titulo().equalsIgnoreCase(nombreLibro))
                .findFirst();
        if (optionalDatosLibros.isPresent()) {
            DatosLibros datosLibros = optionalDatosLibros.get();
            return datosLibros;
        } else {
            System.out.println("No se encontró el libro.");
            return null;
        }
    }

    private void AgregarLibro() {
        DatosLibros datosLibros = DatosLibros();

        if (datosLibros != null) {
            Optional<Libro> existingLibro = repositoryLibro.findByTitulo(datosLibros.titulo());
            if (existingLibro.isPresent()) {
                System.out.println("El libro ya está registrado en la base de datos.");
                return;
            }

            if (datosLibros.autores() != null && !datosLibros.autores().isEmpty()) {
                DatosAutores datosAutor = datosLibros.autores().get(0);
                Autore autor = new Autore(datosAutor);
                repositoryAutor.save(autor);
                Libro libro = new Libro(datosLibros);
                libro.setAutores(autor);
                repositoryLibro.save(libro);
                System.out.println(libro);
            } else {
                System.out.println("No se encontraron autores para el libro.");
            }
        } else {
            System.out.println("No se pudo agregar el libro. DatosLibros es null.");
        }
        System.out.println("==============================================" + "\n");
    }

    private void buscarAutorPorLibro() {
        mostrarLibroBuscado();
        System.out.println("Escribe el nombre del autor del cual quieres buscar");
        String nombreAutor = teclado.nextLine();
        List<Libro> librosEncontrados = libros.stream()
                .filter(libro -> libro.getAutores().getNombre().equalsIgnoreCase(nombreAutor))
                .collect(Collectors.toList());
        if (!librosEncontrados.isEmpty()) {
            librosEncontrados.forEach(System.out::println);
        } else {
            System.out.println("No se encontró el autor.");
        }
        System.out.println("==============================================" + "\n");
    }

    private void mostrarLibroBuscado(){
        libros = repositoryLibro.findAll();
        libros.stream()
                .sorted(Comparator.comparing(Libro::getTotalDescarga))
                .forEach(System.out::println);
        System.out.println("==============================================" + "\n");
    }

    private void mostrarAutorBuscado(){
        autores = repositoryAutor.findAll();
        autores.stream()
                .sorted(Comparator.comparing(Autore::getFechaFallecimieto))
                .forEach(System.out::println);
        System.out.println("==============================================" + "\n");
    }

    private void mostrarListaPorIdioma() {
        System.out.println("Ingresa el idioma que deseas buscar(es-en)");
        String idioma = teclado.nextLine();
        List<Libro> librosFiltrados = repositoryLibro.findByIdioma(idioma);
        if (librosFiltrados.size()>0){
            librosFiltrados.forEach(System.out::println);
            System.out.println("==============================================" + "\n");
        }else {
            System.out.println("No se encontro ningun libro con ese idioma");
        }

    }

}
