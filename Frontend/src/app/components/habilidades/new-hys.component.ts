import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skills } from 'src/app/model/skills';
import { SkillsService } from 'src/app/service/skills.service';

@Component({
  selector: 'app-new-hys',
  templateUrl: './new-hys.component.html',
  styleUrls: ['./new-hys.component.css']
})
export class NewHysComponent implements OnInit {
  nombre: string = '';
  progreso: number;
  img: string = ''

  constructor(
    private skillsS: SkillsService,
    private activatedRouter: ActivatedRoute,
    private router: Router
   ) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const skills = new Skills(this.nombre, this.progreso, this.img);
    this.skillsS.save(skills).subscribe(
      data=>{
        alert("Skill añadido");
        this.router.navigate(['']);
      }, err => {
        alert("Fallo");
        this.router.navigate(['']);
      }
    )
  }

  cancelar(){
    this.router.navigate(['']);
  }

}
