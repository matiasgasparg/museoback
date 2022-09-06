/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.museonat.model.repo;

import com.example.museonat.model.userModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author walke
 */
@Repository
public interface userRepo extends CrudRepository <userModel,Integer> {
   userModel findByUsername(String usuario);

}

