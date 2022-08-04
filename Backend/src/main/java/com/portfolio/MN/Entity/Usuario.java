package com.portfolio.MN.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Por favor, ingrese un nombre valido")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Por favor, ingrese un apellido valido")
    private String apellido;
    
    @Size(min = 1, max = 50, message = "Por favor, ingrese un imagen valida")
    private String imgPerfil;

}
