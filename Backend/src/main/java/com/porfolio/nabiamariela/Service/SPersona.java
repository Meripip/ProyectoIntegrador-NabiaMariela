package com.porfolio.nabiamariela.Service;

import com.porfolio.nabiamariela.Entity.Persona;
import com.porfolio.nabiamariela.Repository.RPersona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SPersona {
    @Autowired 
    RPersona rPersona;
    
    public List<Persona> list() {
        return rPersona.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return rPersona.findById(id);
    }
    
    public Optional<Persona> getByNombreE(String nombreE){
        return rPersona.findByNombreE(nombreE);
    }

    public void save(Persona persona) {
        rPersona.save(persona);
    }

    public boolean existsById(int id){
        return rPersona.existsById(id);
    }
    
    public void delete(int id){
        rPersona.deleteById(id);
    }

    public boolean existsByNombreE(String nombreE){
        return rPersona.existsByNombreE(nombreE);
    }
    
}
