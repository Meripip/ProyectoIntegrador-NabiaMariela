package com.portfolio.MN.Controller;

import com.portfolio.MN.Entity.UsuarioPerso;
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
    public List<UsuarioPerso> getUsuario(){
        return iusuarioService.getUsuario();
    }
    
    @PostMapping("/usuario/crear")
    public String createUsuario(@RequestBody UsuarioPerso usuarioPerso){
        iusuarioService.saveUsuario(usuarioPerso);
        return "El usuario fue creado con éxito";
    }
    
    @DeleteMapping("/usuario/borrar/{id}")
    public String deleteUsuario(@PathVariable Long id){
        iusuarioService.deleteUsuario(id);
        return "El usuario fue eliminado con éxito";
    }
    
    @PutMapping("/usuario/editar/{id}")
    public UsuarioPerso editUsuario(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("imgPerfil") String nuevoImgPerfil){
        UsuarioPerso usuarioPerso = iusuarioService.findUsuario(id);
        usuarioPerso.setNombre(nuevoNombre);
        usuarioPerso.setApellido(nuevoApellido);
        usuarioPerso.setImgPerfil(nuevoImgPerfil);
        
        iusuarioService.saveUsuario(usuarioPerso);
        return usuarioPerso;
    }
    @GetMapping("/usuario/traer/perfil/{id}")
    public UsuarioPerso findUsuario(@PathVariable Long id){
        return   iusuarioService.findUsuario((long) 1);
    }
    //public Usuario findUsuario(){
    //    return   iusuarioService.findUsuario((long)1);
}
