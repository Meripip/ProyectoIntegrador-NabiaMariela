package com.portfolio.MN.Controller;

import com.portfolio.MN.Entity.Usuario;
import com.portfolio.MN.Interface.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UsuarioController {
    
    @Autowired IUsuarioService iusuarioService;
    
    @GetMapping("usuario/traer")
    public List<Usuario> getUsuario(){
        return iusuarioService.getUsuario();
    }
    
    @PostMapping("/usuario/crear")
    public String createUsuario(@RequestBody Usuario usuario){
        iusuarioService.saveUsuario(usuario);
        return "El usuario fue creado con éxito";
    }
    
    @DeleteMapping("/usuario/borrar/{id}")
    public String deleteUsuario(@PathVariable Long id){
        iusuarioService.deleteUsuario(id);
        return "El usuario fue eliminado con éxito";
    }
    
    @PutMapping("/usuario/editar/{id}")
    public Usuario editUsuario(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("imgPerfil") String nuevoImgPerfil){
        Usuario usuario = iusuarioService.findUsuario(id);
        usuario.setNombre(nuevoNombre);
        usuario.setApellido(nuevoApellido);
        usuario.setImgPerfil(nuevoImgPerfil);
        
        iusuarioService.saveUsuario(usuario);
        return usuario;
    }
    @GetMapping("/usuario/traer/perfil")
    public Usuario findUsuario(){
        return   iusuarioService.findUsuario((long) 1);
    }
    
}
