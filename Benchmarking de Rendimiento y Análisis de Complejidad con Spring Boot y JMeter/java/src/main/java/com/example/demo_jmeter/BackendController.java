package com.example.demo_jmeter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/benchmark")
public class BenchmarkController {
// ALGORITMO INEFICIENTE: Dos bucles anidados - Complejidad O(n^2)
    @GetMapping("/ineficiente")
    public String codigoIneficiente(@RequestParam(defaultValue = "5000") int n) {
        long inicio = System.currentTimeMillis();
        long acumulador = 0;
	for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                acumulador += (i + j) % 3;

            }

        }
        
        long fin = System.currentTimeMillis();
        return "Ineficiente O(n^2) completado para n=" + n + " en (fin - inicio) " + (fin - inicio) + " ms.Resultado: " + acumulador;
    }
    // ALGORITMO OPTIMIZADO: Un solo bucle lineal - Complejidad O( n )
    @GetMapping("/optimizado")
    public String codigoOptimizado(@RequestParam(defaultValue = "5000") int n) {
        long inicio = System.currentTimeMillis();
        
        long acumulador = 0;

        // Bucle único lineal O( n )
        for (long i = 0; i < (n * n); i++) {
            acumulador += i % 3;

        }
        
        long fin = System.currentTimeMillis();
        return "Optimizado O(n) completado para n=" + n + " completado en: (fin - inicio) = " + (fin - inicio) + " ms.Resultado: " + acumulador;
    }
}
