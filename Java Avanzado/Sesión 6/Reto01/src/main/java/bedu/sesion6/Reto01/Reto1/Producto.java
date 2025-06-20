package bedu.sesion6.Reto01.Reto1;

import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @Min(1)
    private double precio;

    public Producto() {}

    public Producto(Long id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters, Setters, toString()
    @Override
    public String toString() {
        return String.format("Producto[id=%d, nombre='%s', precio=%.2f]", id, nombre, precio);
    }
}