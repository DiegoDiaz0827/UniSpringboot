package com.campus.uni.service.profesor;

import com.campus.uni.Entities.Profesor;
import com.campus.uni.repository.ProfesorRepository;
import com.campus.uni.service.profesor.IProfesorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService implements IProfesorservice {

    @Autowired
    private ProfesorRepository repo;

    @Override
    public List<Profesor> findAll(){
        return repo.findAll();

    }

    @Override
    public Profesor finbyid(Long id){
        return repo.findById(id).orElse(null);



    }

    @Override
    public Profesor save(Profesor pro){
        return repo.save(pro);

    }

    @Override
    public void deletebyid(Long id){

        repo.deleteById(id);

    }




}
