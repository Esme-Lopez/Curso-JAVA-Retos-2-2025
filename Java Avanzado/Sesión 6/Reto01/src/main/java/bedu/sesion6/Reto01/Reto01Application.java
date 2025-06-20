package bedu.sesion6.Reto01;

import bedu.sesion6.Reto01.Reto1.Producto;
import bedu.sesion6.Reto01.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Reto01Application {

    public static void main(String[] args) {
        SpringApplication.run(Reto01Application.class, args);
    }

    @Bean
    public CommandLineRunner run(ProductoRepository repository) {
        return args -> {
            repository.save(new Producto(null, "Laptop Lenovo", "Portátil potente", 12500));
            repository.save(new Producto(null, "Mouse Logitech", "Mouse inalámbrico", 350));
            repository.save(new Producto(null, "Teclado Mecánico", "Con retroiluminación", 950));
            repository.save(new Producto(null, "Monitor", "Pantalla 24 pulgadas", 3200));

            System.out.println("\nProductos con precio mayor a 500:");
            repository.findByPrecioGreaterThan(500).forEach(System.out::println);

            System.out.println("\nProductos que contienen 'lap':");
            repository.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

            System.out.println("\nProductos con precio entre 400 y 1000:");
            repository.findByPrecioBetween(400, 1000).forEach(System.out::println);

            System.out.println("\nProductos cuyo nombre empieza con 'm':");
            repository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
        };
    }
}
