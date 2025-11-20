package com.campus.uni.service.course;

import com.campus.uni.Entities.Course;
import com.campus.uni.Entities.Profesor;
import com.campus.uni.repository.CourseRepository;
import com.campus.uni.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Courseservice implements Icursoservice {


    @Autowired
    private CourseRepository repo;

    @Autowired
    private ProfesorRepository repo2;

    @Override
    public List<Course> findall(){
    return repo.findAll();

    }

    @Override
    public Course findbyid(Long id){
        return repo.findById(id).orElse(null);

    }

    @Override
    public Course save(Course c, Long id){

        Profesor pro = repo2.findById(id).orElse(null);
        if(pro != null){
         c.setProfesor(pro);
            return repo.save(c);
        }
        return null;

    }

    @Override
    public List<Course> findByProfesorNombre (String name){

        return repo.findByProfesorNombre(name);
    }




}
