package com.campus.uni.service.course;

import com.campus.uni.Entities.Course;
import com.campus.uni.Entities.Student;

import java.util.List;

public interface Icursoservice {

    List<Course>findall();
    Course findbyid(Long id);
    Course save(Course c,Long id);
    List<Course>findByProfesorNombre(String name);
    Course actprofesor(Long courseid, Long profesorId);
}
