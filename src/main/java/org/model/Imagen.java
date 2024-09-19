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
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    // Getters and setters

    @Override
    public String toString() {
        return "\nId " + id +
                "\nDescripcion " + denominacion + "\n";
    }
}