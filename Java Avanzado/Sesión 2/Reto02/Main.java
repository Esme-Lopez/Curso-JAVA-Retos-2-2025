package Reto02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando simulación de acceso al recurso...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        // Creamos un pool de 4 hilos para simular concurrencia
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new Profesional("Dra. Sánchez", salaCirugia));
        executor.submit(new Profesional("Dr. Gómez", salaCirugia));
        executor.submit(new Profesional("Enfermero López", salaCirugia));
        executor.submit(new Profesional("Dra. Ruiz", salaCirugia));

        executor.shutdown(); // No se aceptan más tareas
    }
}