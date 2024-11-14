package com.boris.literatura.dto;

import com.boris.literatura.model.Autore;


public record LibroDTO(
        String titulo,
        Autore autore,
        String idioma,
        Integer totalDescarga) {
}
