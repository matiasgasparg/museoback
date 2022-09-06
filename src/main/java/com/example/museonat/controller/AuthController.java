/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.museonat.controller;

import com.example.museonat.model.userModel;
import com.example.museonat.services.userService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author walke
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/login")

public class AuthController {
    @Autowired
    private userService UserService;
    
   private String getJWTToken(String username){
       String secretKey="wa4k3r";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
		.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("api3320")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 60*60*1000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
   }
    
    @PostMapping 
   public ResponseEntity<userModel> login (@Validated @RequestBody userModel user){
       userModel usuario= UserService.getByUsername(user.getUsername());
       if(usuario.getPassword().equals(user.getPassword())){
           String token= getJWTToken(user.getUsername());
           usuario.setToken(token);
           usuario.setPassword(null);
           return ResponseEntity.ok().body(usuario);
       }
       else{
           return ResponseEntity.badRequest().build();
       }
       
   }
  

    
    
}
