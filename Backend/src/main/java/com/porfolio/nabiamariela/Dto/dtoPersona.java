/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.nabiamariela.Dto;

import javax.validation.constraints.NotBlank;


public class dtoPersona {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String apellidoE;
    @NotBlank
    private String imgE;
    @NotBlank
    private String descripE;
    @NotBlank
    private String tituloE;

    public dtoPersona() {
    }

    public dtoPersona(String nombreE, String apellidoE, String imgE, String descripE, String tituloE) {
        this.nombreE = nombreE;
        this.apellidoE = apellidoE;
        this.imgE = imgE;
        this.descripE = descripE;
        this.tituloE = tituloE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getApellidoE() {
        return apellidoE;
    }

    public void setApellidoE(String apellidoE) {
        this.apellidoE = apellidoE;
    }

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }

    public String getDescripE() {
        return descripE;
    }

    public void setDescripE(String descripE) {
        this.descripE = descripE;
    }

    public String getTituloE() {
        return tituloE;
    }

    public void setTituloE(String tituloE) {
        this.tituloE = tituloE;
    }
    
    
}
