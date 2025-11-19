package com.campus.uni.service.course;

import com.campus.uni.Entities.Course;

import java.util.List;

public interface Icursoservice {

    List<Course>findall();
    Course findbyid(Long id);
    Course save(Course c,Long id);
    List<Course>findByprofesor_nombre(String name);
}
