package com.campus.uni.controller;

import com.campus.uni.Entities.Student;
import com.campus.uni.service.student.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class Studentscontroller {

    @Autowired
    private Studentservice service;

    @GetMapping
    public List<Student> getall(){
        return service.findall();

    }

    // en el json body se puede incluir el objeto detalle anidado
    @PostMapping
    public Student createstudent (@RequestBody Student s){
   return service.crear(s);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getstudentid(@PathVariable  Long id){
        Student stud = service.findbyid(id);
        if(stud != null){

            return ResponseEntity.ok(stud);

        }
        return ResponseEntity.notFound().build();

    }

    //endpoint para relaciones N:N
    // Put /api/estudiantes/cursos/3

@PutMapping("/{esid}/cursos/{courseid}")
    public ResponseEntity<Student> asignarcurso(@PathVariable  Long esid,@PathVariable Long courseid){
        Student student = service.asignarcurso(esid,courseid);
        if(student != null){
             return ResponseEntity.ok(student);
        }

        return ResponseEntity.notFound().build();
    }

}
