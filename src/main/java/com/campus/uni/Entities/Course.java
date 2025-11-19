package com.campus.uni.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "cursos")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_curso")
    private String nombreCurso;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToMany(mappedBy = "cursos")
    @JsonIgnore
    private Set<Student> estudiantes;

    @Override
    public int hashCode(){
        return (id==null)? 0: id.hashCode();

    }

    @Override
    public boolean equals(Object o){

        if(this == o) return true;
        if(!(o instanceof  Course)) return false;
        Course other = (Course) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public String toString(){
        return "Curso = {"+ "id: "+id+"Nombre: "+ nombreCurso+"}";
    }

}
