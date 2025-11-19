package com.campus.uni.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estudiantes")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "nombre_completo", length = 100,nullable = false)
    private String nombre;

    @Column(unique = true)
    private String email;

    @Column(name = "Fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Transient
    private Integer Edad;

    @JoinColumn(name = "detalle_id", referencedColumnName = "id")
    @OneToOne(cascade =  CascadeType.ALL)
    private StudentDetail detalle;

    @ManyToMany
    @JoinTable(name = "Estudiante_curso",joinColumns = @JoinColumn(name = "estudiante_id"),inverseJoinColumns = @JoinColumn(name = "curso_id"))
    @JsonIgnore
    private Set<Course> cursos = new HashSet<>();

    @Override
    public int hashCode(){
        return (id==null)? 0: id.hashCode();

    }

    @Override
    public boolean equals(Object o){

        if(this == o) return true;
        if(!(o instanceof  Student)) return false;
        Student other = (Student) o;
        return id != null && id.equals(other.getId());
    }


    @Override
    public String toString(){
        return "Estudiante {"+"id: "+id+" Nombre: "+nombre+" Email: "+email+"}";
    }
}
