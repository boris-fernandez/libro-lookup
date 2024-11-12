package com.boris.literatura.main;

import com.boris.literatura.model.Datos;
import com.boris.literatura.service.ConsumoAPI;
import com.boris.literatura.service.ConvertirDatos;

import java.util.Scanner;

public class Principal {
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private Scanner scanner = new Scanner(System.in);
    private ConvertirDatos conversor = new ConvertirDatos();
    private static String URL_BASE = "https://gutendex.com/books/";

    public void mostrarElMenu(){
        int opcion = -1;

        while(opcion != 0){
            String menu = """
                    1 - Buscar 
                    """
        }

    }
}
