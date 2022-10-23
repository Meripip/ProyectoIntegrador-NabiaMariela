/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.nabiamariela.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String urlE;
    @NotBlank
    private String imgE;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreE, String descripcionE, String urlE, String imgE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.urlE = urlE;
        this.imgE = imgE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getUrlE() {
        return urlE;
    }

    public void setUrlE(String urlE) {
        this.urlE = urlE;
    }
    
    public String getImgE() {
        return imgE;
    }
    
    public void setImgE(String imgE) {
        this.imgE = imgE;
    }

}
