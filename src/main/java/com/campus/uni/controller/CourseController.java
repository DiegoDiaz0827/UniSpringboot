package com.campus.uni.controller;

import com.campus.uni.Entities.Course;
import com.campus.uni.Entities.Student;
import com.campus.uni.service.course.Courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CourseController {

    @Autowired
    private Courseservice service;

    @GetMapping
    public List<Course> getallcourses() {
        return service.findall();
    }

    // Endpoint para crear un curso con profesor
    @PostMapping("/{id}")
    public ResponseEntity<Course> createcourse(@RequestBody Course c, @PathVariable Long id){

        Course course = service.save(c,id);
        if (course != null){
            return  ResponseEntity.ok(course);

        }

        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/debug")
    public List<String> debug() {
        return service.findall()
                .stream()
                .map(c -> c.getProfesor().getNombre())
                .toList();
    }

    @GetMapping("/buscar")
    public List<Course> cursosbyprofesor(@RequestParam String nameprofesor){
        return service.findByProfesorNombre(nameprofesor);

    }

    @PutMapping("/actualizar/{idc}/{idpro}")
    public ResponseEntity<Course> cambiarprofesor(@PathVariable Long idc, @PathVariable Long idpro){
        Course c = service.actprofesor(idc,idpro);
        if(c != null){
            return ResponseEntity.ok(c);
        }

        return ResponseEntity.notFound().build();

    }




}
