package com.example.demo_jmeter;

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoJmeterApplication {
    public static void main(String[] args) {
		//mvn clean compile spring-boot:run
        SpringApplication.run(DemoJmeterApplication.class, args);
    }
	// Muestra en consola las URLs listas para probar (navegador, curl o JMeter)
    @Bean
    CommandLineRunner mostrarEndpoints() {
        return args -> {
            System.out.println("\n=== Benchmark listo ===");
            System.out.println("Ineficiente: http://localhost:8080/api/benchmark/ineficiente?n=2000");
            System.out.println("Optimizado : http://localhost:8080/api/benchmark/optimizado?n=2000\n");
        };
    }

}
