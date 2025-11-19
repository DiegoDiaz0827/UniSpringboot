package com.campus.uni.service.student;

import com.campus.uni.Entities.Student;

import java.util.List;

public interface IStudentservice {


    Student crear(Student s);
    Student asignarcurso(Long Studentid,Long cursoId);
    List<Student> findall();
    Student findbyid(Long id);
    void deletestudent(Long id);


}
