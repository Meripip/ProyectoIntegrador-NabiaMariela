
package com.portfolio.MN.Repository;

import com.portfolio.MN.Entity.UsuarioPerso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioPersoRepository extends JpaRepository<UsuarioPerso,Long>{
    
}
