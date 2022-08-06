
package com.portfolio.MN.Service;

import com.portfolio.MN.Entity.UsuarioPerso;
import com.portfolio.MN.Interface.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.MN.Repository.IUsuarioPersoRepository;

@Service
public class ImpUsuarioService implements IUsuarioService{
    
    @Autowired IUsuarioPersoRepository iusuarioRepository;

    @Override
    public List<UsuarioPerso> getUsuario() {
        List<UsuarioPerso> usuarioPerso = iusuarioRepository.findAll();
        return usuarioPerso;
    }

    @Override
    public void saveUsuario(UsuarioPerso usuarioPerso) {
       iusuarioRepository.save(usuarioPerso);
    }

    @Override
    public void deleteUsuario(Long id) {
       iusuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioPerso findUsuario(Long id) {
        
       UsuarioPerso usuarioPerso = iusuarioRepository.findById(id).orElse(null);
       return usuarioPerso;

    }
    
}
