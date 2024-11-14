package com.boris.literatura.repository;

import com.boris.literatura.model.Autore;
import com.boris.literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autore, Long> {
    @Query("SELECT a FROM Autore a WHERE :año BETWEEN a.fechaNacimiento AND a.fechaFallecimieto")
    List<Autore> filtrarAutorvivoporAño(@Param("año") int año);

    Optional<Autore> findByFechaNacimiento(int fechaNacimiento);
}
