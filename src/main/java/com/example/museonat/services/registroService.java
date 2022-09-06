/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.museonat.services;

import com.example.museonat.model.registroModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.museonat.model.repo.registroRepo;

/**
 *
 * @author walke
 */
@Service
public class registroService {
    @Autowired
    registroRepo RegisterRepo;
    
    public List<registroModel>getAll(){
        return (List<registroModel>)RegisterRepo.findAll();
    }
    public ResponseEntity <registroModel>getById(int id){
        Optional<registroModel> registro=RegisterRepo.findById(id);
        if(registro.isPresent()){
            return ResponseEntity.ok().body(registro.get());
            
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    public registroModel save(registroModel registro){
    return RegisterRepo.save(registro);
}
    public void  deleteRegistro(int id){
        RegisterRepo.deleteById(id);
    }
         public void saveRegistro(registroModel registro){
        RegisterRepo.save(registro);
    }
    
}
