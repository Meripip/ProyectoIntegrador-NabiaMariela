import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-edit-navbar',
  templateUrl: './edit-navbar.component.html',
  styleUrls: ['./edit-navbar.component.css']
})
export class EditNavbarComponent implements OnInit {

  usuario: Persona = null;

  constructor(
    private personaService: PersonaService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.personaService.detail(id).subscribe(
      data =>{
        this.usuario = data;
      }, err =>{
        alert("Error al modificar");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.personaService.update(id, this.usuario).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err =>{
        alert("Error al modificar");
        this.router.navigate(['']);
      }
    )
  }

  cancelar(){
    this.router.navigate(['']);
  }

}

