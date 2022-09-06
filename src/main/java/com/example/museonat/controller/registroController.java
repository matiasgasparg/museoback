/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.museonat.controller;

import com.example.museonat.model.registroModel;
import com.example.museonat.services.registroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@RestController
@RequestMapping("/api/registros")
public class registroController {
    @Autowired
    private registroService RegistroService;
    @GetMapping ("/all")
    
    public List<registroModel> findAll(){
        return RegistroService.getAll();
    }
  @GetMapping ("/{id}")
    public ResponseEntity <registroModel> getById(@PathVariable (value="id")int id){
        return RegistroService.getById(id);
    }
    
    @PutMapping("/{id}")
    
    public ResponseEntity<registroModel> update(@PathVariable(value="id")int id,@Validated @RequestBody registroModel registro){
        if(id==registro.idregistros){
            registroModel registroNew= RegistroService.save(registro);
            return ResponseEntity.ok().body(registroNew);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
      @PostMapping ("/")
       public String createRegistro (@RequestBody registroModel registro){
       RegistroService.saveRegistro(registro);
       return "El registro fue guardado correctamente";
   }
      @DeleteMapping("/{id}")
   
   public String deleteRegistro(@PathVariable int id){
       RegistroService.deleteRegistro(id);
       return "El registro fue eliminado correctamente";
   }
    
}
