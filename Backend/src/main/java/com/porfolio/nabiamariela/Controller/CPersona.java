package com.porfolio.nabiamariela.Controller;

import com.porfolio.nabiamariela.Dto.dtoPersona;
import com.porfolio.nabiamariela.Entity.Persona;
import com.porfolio.nabiamariela.Service.SPersona;
import com.porfolio.nabiamariela.Security.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")

@CrossOrigin(origins=  "https://portfolionabiamariela.web.app")
public class CPersona {
    @Autowired 
    SPersona sPersona;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!sPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if (StringUtils.isBlank(dtopersona.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sPersona.existsByNombreE(dtopersona.getNombreE())){
            return new ResponseEntity(new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = new Persona(dtopersona.getNombreE(), dtopersona.getApellidoE(), dtopersona.getTituloE(), dtopersona.getImgE(), dtopersona.getDescripE());
        sPersona.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona agregada!"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if (!sPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sPersona.delete(id);
        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
       if (!sPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if (sPersona.existsByNombreE(dtopersona.getNombreE()) && sPersona.getByNombreE(dtopersona.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa Persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopersona.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = sPersona.getOne(id).get();
        persona.setNombreE(dtopersona.getNombreE());
        persona.setApellidoE(dtopersona.getApellidoE());
        persona.setTituloE(dtopersona.getTituloE());
        persona.setImgE(dtopersona.getImgE());
        persona.setDescripE(dtopersona.getDescripE());
        
        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK);
        
    }
    /*
    @PutMapping("/update/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("NombreE")String nuevoNombre,
            @RequestParam("ApellidoE")String nuevoApellido,
            @RequestParam("ImgE") String ImgE){
        
         Persona persona = sPersona.getOne(id).get();
        
        persona.setNombreE(nuevoNombre);
        persona.setApellidoE(nuevoApellido);
        
        sPersona.save(persona);
        return persona;
        
        } */
    
}
