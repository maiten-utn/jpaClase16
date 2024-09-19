package org.model;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Articulo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UnidadMedida unidadMedida;
    @OneToOne(cascade = CascadeType.ALL)
    private Imagen imagen;
    // Getters and setters

    @Override
    public String toString() {
        return
                "Id " + id +
                "\nDenominacion " + denominacion + '\'' +
                "\nPrecioVenta " + precioVenta +
                "\nPrecioCompra " + precioCompra +
                "\nStockActual " + stockActual +
                "\nStockMaximo " + stockMaximo +
                "\nUnidadMedida " + unidadMedida +
                "\nImagen: " + imagen ;
    }
}