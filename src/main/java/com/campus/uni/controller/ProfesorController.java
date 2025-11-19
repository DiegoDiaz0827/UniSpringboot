package com.campus.uni.controller;

import com.campus.uni.Entities.Profesor;
import com.campus.uni.service.profesor.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorservice;

    @GetMapping
    public List<Profesor> getallprofesors(){

        return profesorservice.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> getprofesorbyid(@PathVariable Long id){
        Profesor prof = profesorservice.finbyid(id);
        if(prof != null){
           return ResponseEntity.ok(prof);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Profesor createprofesor(@RequestBody Profesor prof){

     return profesorservice.save(prof);

    }

}
