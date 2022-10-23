import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from '../../model/persona.model';
import { PersonaService } from '../../service/persona.service';
import { TokenService } from '../../service/token.service';  


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  persona: Persona [] = [];

  constructor(public personaService: PersonaService,  private tokenService: TokenService, private router:Router ) { }
  isLogged = false;

  ngOnInit(): void {
     this.cargarPersona();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    } 

  }

  onLogOut():void{
    this.tokenService.logOut();
    window.location.reload();
  }

  login(){
    this.router.navigate(['/login'])
  }

 cargarPersona(): void{
    this.personaService.lista().subscribe(
      data => {
        this.persona = data;
      }
    )
  }

  delete(id?: number){
    if(id != undefined){
      this.personaService.delete(id).subscribe(
        data => {
          this.cargarPersona();
        }, err => {
          alert("No se pudo eliminar");
        }
      )
    }
  }

 
}
