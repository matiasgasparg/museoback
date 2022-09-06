/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.museonat.controller;

import com.example.museonat.model.registroModel;
import com.example.museonat.model.userModel;
import com.example.museonat.services.userService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author walke
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class userController {
    
    @Autowired
    private userService UserService;
       /*
   @GetMapping("/")
    public String index() {
	
        return "index";
       
	}
	*/
    
    @GetMapping ("/all")
    
    public List<userModel> findAll(){
        return UserService.getAll();
    }
  @GetMapping ("/{id}")
    public ResponseEntity <userModel> getById(@PathVariable (value="id")int id){
        return UserService.getById(id);
    }
    
    @PutMapping("/{id}")
    
    public ResponseEntity<userModel> update(@PathVariable(value="id")int id,@Validated @RequestBody userModel user){
        if(id==user.iduser){
            userModel userNew= UserService.save(user);
            return ResponseEntity.ok().body(userNew);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
      @PostMapping ("/")
       public String createUser (@RequestBody userModel user){
       UserService.saveUser(user);
       return "El user fue guardado correctamente";
   }
      @DeleteMapping("/{id}")
   
   public String deleteUser(@PathVariable int id){
       UserService.deleteUser(id);
       return "El user fue eliminado correctamente";
   }
    
}

    

