package com.campus.uni.service.profesor;

import com.campus.uni.Entities.Profesor;

import java.util.List;

public interface IProfesorservice {


    Profesor finbyid(Long id);
    Profesor save(Profesor profesor);
    void deletebyid(Long id);


    List<Profesor> findAll();
}
