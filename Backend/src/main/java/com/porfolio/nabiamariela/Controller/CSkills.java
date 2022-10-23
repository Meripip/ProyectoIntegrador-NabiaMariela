/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.nabiamariela.Controller;

import com.porfolio.nabiamariela.Dto.dtoSkills;
import com.porfolio.nabiamariela.Entity.Skills;
import com.porfolio.nabiamariela.Security.Controller.Mensaje;
import com.porfolio.nabiamariela.Service.SSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")

@CrossOrigin(origins= "http://localhost:4200")
public class CSkills {
    @Autowired
    SSkills sSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
   @GetMapping("/detail/{id}")
   public ResponseEntity<Skills> getById(@PathVariable("id") int id){
       if(!sSkills.existsById(id))
           return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
       Skills skills = sSkills.getOne(id).get();
       return new ResponseEntity(skills, HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") int id){
       if(!sSkills.existsById(id)){
           return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
       }
       sSkills.delete(id);
       return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
   }
   
   @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
       if(StringUtils.isBlank(dtoskills.getNombre()))
           return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       if(sSkills.existsByNombre(dtoskills.getNombre()))
           return new ResponseEntity(new Mensaje("Ese skill ya existe"), HttpStatus.BAD_REQUEST);
       
       Skills skills = new Skills(dtoskills.getNombre(), dtoskills.getProgreso(), dtoskills.getImg());
       sSkills.save(skills);
       
       return new ResponseEntity(new Mensaje("Skill agregado"), HttpStatus.OK);
   }
   
   @PutMapping("/update/{id}")
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){
       if(!sSkills.existsById(id))
           return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
       if(sSkills.existsByNombre(dtoskills.getNombre()) && sSkills.getByNombre(dtoskills.getNombre()).get().getId() !=id)
           return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
       if(StringUtils.isBlank(dtoskills.getNombre()))
           return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
       
       Skills skills = sSkills.getOne(id).get();
       skills.setNombre(dtoskills.getNombre());
       skills.setProgreso(dtoskills.getProgreso());
       skills.setImg(dtoskills.getImg());
       
       sSkills.save(skills);
       return new ResponseEntity(new Mensaje("Skill actualizado"), HttpStatus.OK);
   }
}
