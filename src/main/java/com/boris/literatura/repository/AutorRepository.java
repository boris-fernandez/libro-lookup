package com.boris.literatura.repository;

import com.boris.literatura.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autore, Long> {
}
