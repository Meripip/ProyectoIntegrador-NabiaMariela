package com.porfolio.nabiamariela.Repository;

import com.porfolio.nabiamariela.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPersona extends JpaRepository<Persona,Integer> {
    public Optional<Persona> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}
