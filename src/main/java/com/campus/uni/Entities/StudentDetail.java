package com.campus.uni.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalles_estudiantes")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private String telefono;

    @OneToOne(mappedBy = "detalle")
    @JsonIgnore
    private Student estudiante;

}
