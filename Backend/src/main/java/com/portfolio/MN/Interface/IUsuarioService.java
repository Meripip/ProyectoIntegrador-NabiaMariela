
package com.portfolio.MN.Interface;

import com.portfolio.MN.Entity.Usuario;
import java.util.List;


public interface IUsuarioService {
    //trer los usuarios
    public List<Usuario> getUsuario();
    
    //guardar el objeto usuario
    public void saveUsuario(Usuario usuario);
    
    //eliminar un usuario por Id
    public void deleteUsuario(Long id);
    
    //buscar un usuario por Id
    public Usuario findUsuario(Long id);
    
}
