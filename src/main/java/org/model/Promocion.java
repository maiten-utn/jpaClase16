package org.model;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private Long id;
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    @Enumerated(EnumType.STRING)
    private TipoPromocion tipoPromocion;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "promocion_imagen",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "imagen_id"))
    @Builder.Default
    private Set<Imagen> imagenPromo = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "promocion_articulo",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "articulo_id"))
    private Set<Articulo> articulos = new HashSet<>();

    @Override
    public String toString() {
        return "Promocion " + denominacion + ":"+
                "\nid " + id +
                "\nFechaDesde " + fechaDesde +
                "\nFechaHasta " + fechaHasta +
                "\nHoraDesde " + horaDesde +
                "\nHoraHasta " + horaHasta +
                "\nDescripcionDescuento " + descripcionDescuento +
                "\nPrecioPromocional " + precioPromocional +
                "\nTipoPromocion " + tipoPromocion ;
    }
}