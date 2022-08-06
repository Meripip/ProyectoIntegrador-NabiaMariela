
package com.portfolio.MN.Interface;

import com.portfolio.MN.Entity.UsuarioPerso;
import java.util.List;


public interface IUsuarioService {
    //trer los usuarios
    public List<UsuarioPerso> getUsuario();
    
    //guardar el objeto usuario
    public void saveUsuario(UsuarioPerso usuarioPerso);
    
    //eliminar un usuario por Id
    public void deleteUsuario(Long id);
    
    //buscar un usuario por Id
    public UsuarioPerso findUsuario(Long id);
    
}
