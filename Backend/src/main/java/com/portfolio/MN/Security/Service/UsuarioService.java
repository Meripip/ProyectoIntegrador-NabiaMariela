
package com.portfolio.MN.Security.Service;



import com.portfolio.MN.Security.Entity.Usuario;
import com.portfolio.MN.Security.Repository.iUsuarioRepository;


import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
     @Autowired
     iUsuarioRepository iusuarioRepository;
     
     public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
         return iusuarioRepository.findByNombreUsuario(nombreUsuario);
     }
     
     //comprobar si el usuario ya existe
     public boolean existsByNombreUsuario(String nombreUsuario){
         return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
     }
     
     //si el email existe
     public boolean existsByEmail(String email){
         return iusuarioRepository.existsByEmail(email);
     }
     
     //crear un usuario new
     public void save(Usuario usuario){
         iusuarioRepository.save(usuario);
     }
     
     
}
