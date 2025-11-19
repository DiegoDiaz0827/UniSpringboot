package com.campus.uni.service.student;

import com.campus.uni.Entities.Course;
import com.campus.uni.Entities.Student;
import com.campus.uni.repository.CourseRepository;
import com.campus.uni.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Studentservice implements IStudentservice{

    @Autowired
    private StudentRepository repo;
    @Autowired
    private CourseRepository repo2;
    @Override
    public Student crear(Student s) {
        if (s.getDetalle() != null){
            s.getDetalle().setEstudiante(s);
        }

        return repo.save(s);
    }

    @Override
    public Student asignarcurso(Long Studentid, Long cursoId) {
        Student student = repo.findById(Studentid).orElse(null);
        Course course = repo2.findById(cursoId).orElse(null);

        if(student != null & course != null){
            student.getCursos().add(course);
            return repo.save(student);
        }
        return null;
    }

    @Override
    public List<Student> findall() {
        return repo.findAll();
    }

    @Override
    public Student findbyid(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deletestudent(Long id) {
         repo.deleteById(id);
    }
}
