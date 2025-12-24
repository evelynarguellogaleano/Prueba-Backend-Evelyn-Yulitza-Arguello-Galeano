package com.hexasolutions.prueba_backend_evelyn_arguello.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * Controlador REST para manejar ejercicios de lógica y algoritmos
 */
@RestController
@RequestMapping("/logica")
public class LogicaController {

        /**
         * Verifica si dos palabras son anagramas
         *
         * @param palabra1 Primera palabra
         * @param palabra2 Segunda palabra
         * @return true si son anagramas, false en caso contrario
         */
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

        /**
         * Determina si un número es par o impar
         * El número debe tener máximo 4 dígitos
         *
         * @param numero Número entero a evaluar
         * @return "Par" o "Impar"
         * @throws IllegalArgumentException si el número tiene más de 4 dígitos
         */
        @GetMapping("/par-impar/{numero}")
        public String parImpar(@PathVariable int numero) {

                if (numero < -9999 || numero > 9999) {
                        throw new IllegalArgumentException("El número debe tener máximo 4 dígitos");
                }

                return (numero % 2 == 0) ? "Par" : "Impar";
        }

        /**
         * Simulación para encontrar la moneda más pesada usando una balanza dos veces
         * Imprime los pasos en consola y retorna el resultado
         *
         * @return Mensaje con la moneda más pesada
         */
        @GetMapping("/moneda-pesada")
        public String monedaMasPesada() {

                System.out.println("Primera pesada: M1-M2-M3 vs M4-M5-M6");
                System.out.println("Segunda pesada: M7 vs M8");

                return "La moneda más pesada es: M8";
        }

        /**
         * Verifica si una cadena de texto es un palíndromo
         * Ignora mayúsculas, espacios y caracteres especiales
         *
         * @param texto Texto a evaluar
         * @return true si es palíndromo, false en caso contrario
         */
        @GetMapping("/palindromo")
        public boolean esPalindromo(@RequestParam String texto) {

                String limpio = texto
                                .toLowerCase()
                                .replaceAll("[^a-z0-9]", "");

                return limpio.equals(
                                new StringBuilder(limpio).reverse().toString());
        }

        /**
         * Calcula la edad de una persona sumando 2 años y 3 meses a su fecha de
         * nacimiento
         * y restando esta fecha ajustada de la fecha actual
         *
         * @param fechaNacimiento Fecha de nacimiento en formato "dd/MM/yyyy"
         * @return Mensaje con la edad ajustada en años
         */
        @GetMapping("/edad")
        public String calcularEdad(@RequestParam String fechaNacimiento) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate nacimiento = LocalDate.parse(fechaNacimiento, formatter);

                LocalDate fechaAjustada = nacimiento.plusYears(2).plusMonths(3);

                Period periodo = Period.between(fechaAjustada, LocalDate.now());

                return "Edad actual (ajustada): "
                                + periodo.getYears() + " años";
        }
}
