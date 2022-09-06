/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.museonat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author walke
 */
@Entity
@Table (name="registros")
public class registroModel {
     @Id
   @Column (unique= true ,nullable= false)
     public int idregistros;
     private int numeroRegistro;
     private String clasificacioClase;
     private String clasificacionOrden;
     private String clasificacionFamilia;
     private String clasificacionGenero;
     private String nombreCientifico;
     private String linkImg;
     private String descripcion;

    public registroModel() {
    }

    public registroModel(int idregistros, int numeroRegistro, String clasificacioClase, String clasificacionOrden, String clasificacionFamilia, String clasificacionGenero, String nombreCientifico, String linkImg, String descripcion) {
        this.idregistros = idregistros;
        this.numeroRegistro = numeroRegistro;
        this.clasificacioClase = clasificacioClase;
        this.clasificacionOrden = clasificacionOrden;
        this.clasificacionFamilia = clasificacionFamilia;
        this.clasificacionGenero = clasificacionGenero;
        this.nombreCientifico = nombreCientifico;
        this.linkImg = linkImg;
        this.descripcion = descripcion;
    }

    public int getIdregistros() {
        return idregistros;
    }

    public void setIdregistros(int idregistros) {
        this.idregistros = idregistros;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getClasificacioClase() {
        return clasificacioClase;
    }

    public void setClasificacioClase(String clasificacioClase) {
        this.clasificacioClase = clasificacioClase;
    }

    public String getClasificacionOrden() {
        return clasificacionOrden;
    }

    public void setClasificacionOrden(String clasificacionOrden) {
        this.clasificacionOrden = clasificacionOrden;
    }

    public String getClasificacionFamilia() {
        return clasificacionFamilia;
    }

    public void setClasificacionFamilia(String clasificacionFamilia) {
        this.clasificacionFamilia = clasificacionFamilia;
    }

    public String getClasificacionGenero() {
        return clasificacionGenero;
    }

    public void setClasificacionGenero(String clasificacionGenero) {
        this.clasificacionGenero = clasificacionGenero;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "registroModel{" + "idregistros=" + idregistros + ", numeroRegistro=" + numeroRegistro + ", clasificacioClase=" + clasificacioClase + ", clasificacionOrden=" + clasificacionOrden + ", clasificacionFamilia=" + clasificacionFamilia + ", clasificacionGenero=" + clasificacionGenero + ", nombreCientifico=" + nombreCientifico + ", linkImg=" + linkImg + ", descripcion=" + descripcion + '}';
    }

    
}