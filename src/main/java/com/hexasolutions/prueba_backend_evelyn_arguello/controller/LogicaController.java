package com.hexasolutions.prueba_backend_evelyn_arguello.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@RestController
@RequestMapping("/logica")
public class LogicaController {


    @GetMapping("/anagrama")
    public boolean esAnagrama(
            @RequestParam String palabra1,
            @RequestParam String palabra2) {

        char[] a = palabra1.toLowerCase().toCharArray();
        char[] b = palabra2.toLowerCase().toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }


    @GetMapping("/par-impar/{numero}")
    public String parImpar(@PathVariable int numero) {

        if (numero < -9999 || numero > 9999) {
            throw new IllegalArgumentException("El número debe tener máximo 4 dígitos");
        }

        return (numero % 2 == 0) ? "Par" : "Impar";
    }

    @GetMapping("/moneda-pesada")
    public String monedaMasPesada() {


        System.out.println("Primera pesada: M1-M2-M3 vs M4-M5-M6");
        System.out.println("Segunda pesada: M7 vs M8");

        return "La moneda más pesada es: M8";
    }


    @GetMapping("/palindromo")
    public boolean esPalindromo(@RequestParam String texto) {

        String limpio = texto
                .toLowerCase()
                .replaceAll("[^a-z0-9]", "");

        return limpio.equals(
                new StringBuilder(limpio).reverse().toString()
        );
    }


    @GetMapping("/edad")
    public String calcularEdad(@RequestParam String fechaNacimiento) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate nacimiento =
                LocalDate.parse(fechaNacimiento, formatter);

        LocalDate fechaAjustada =
                nacimiento.plusYears(2).plusMonths(3);

        Period periodo =
                Period.between(fechaAjustada, LocalDate.now());

        return "Edad actual (ajustada): "
                + periodo.getYears() + " años";
    }
}
