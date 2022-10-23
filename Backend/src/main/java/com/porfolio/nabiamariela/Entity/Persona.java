package com.porfolio.nabiamariela.Entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombreE;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellidoE;
    
    @NotNull
    @Size(min = 1, max = 500, message = "no cumple con la longitud")
    private String descripE;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String tituloE;
    
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String imgE;

    public Persona() {
    }

    public Persona(String nombreE, String apellidoE, String descripE, String tituloE, String imgE) {
        this.nombreE = nombreE;
        this.apellidoE = apellidoE;
        this.descripE = descripE;
        this.tituloE = tituloE;
        this.imgE = imgE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }

    
}
