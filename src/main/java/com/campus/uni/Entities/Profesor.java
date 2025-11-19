package com.campus.uni.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "profesores")
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String Facultad;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Course> cursosasignados;

    @Override
    public int hashCode(){
        return (id==null)? 0: id.hashCode();

    }

    @Override
    public boolean equals(Object o){

        if(this == o) return true;
        if(!(o instanceof  Course)) return false;
        Profesor other = (Profesor) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public String toString(){
        return "Profesor = {"+"id: "+id +" Nombre: "+nombre +" Facultad: "+ Facultad+"}";
    }
}
