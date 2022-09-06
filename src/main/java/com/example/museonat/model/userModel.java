/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.museonat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author walke
 */

@Entity
@Table (name="user")
public class userModel {
    @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)  
        public int iduser;        
        private String username;
        private String password;
          @Transient

        private String token;

    public userModel() {
    }

    public userModel(int iduser, String username, String password, String token) {
        this.iduser = iduser;
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "userModel{" + "iduser=" + iduser + ", username=" + username + ", password=" + password + ", token=" + token + '}';
    }

    
}