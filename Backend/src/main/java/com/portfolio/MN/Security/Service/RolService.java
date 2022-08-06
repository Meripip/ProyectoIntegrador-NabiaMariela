
package com.portfolio.MN.Security.Service;

import com.portfolio.MN.Security.Entity.Rol;
import com.portfolio.MN.Security.Enums.RolNombre;
import com.portfolio.MN.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRespository;
    
    //crear objeto rolnombre
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        
        return irolRespository.findByRolNombre(rolNombre);
    }
    
    //guardar cambios
    public void save(Rol rol){
        irolRespository.save(rol);
    }
    
    
    
}
