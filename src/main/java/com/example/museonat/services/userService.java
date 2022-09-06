/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.museonat.services;

import com.example.museonat.model.registroModel;
import com.example.museonat.model.repo.userRepo;
import com.example.museonat.model.userModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author walke
 */
@Service

public class userService {
    @Autowired
    userRepo UserRepo ;
    
    public List<userModel>getAll(){
        return (List<userModel>)UserRepo.findAll();
    }
    public ResponseEntity <userModel>getById(int id){
        Optional<userModel> user=UserRepo.findById(id);
        if(user.isPresent()){
            return ResponseEntity.ok().body(user.get());
            
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    public userModel save(userModel user){
    return UserRepo.save(user);
}
    public void  deleteUser(int id){
        UserRepo.deleteById(id);
    }
         public void saveUser(userModel user){
        UserRepo.save(user);
    }
         public userModel getByUsername(String usuario){
    return UserRepo.findByUsername(usuario);
}
    
}
