import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApphomeComponent } from './components/apphome/apphome.component';
import { EditEducacionComponent } from './components/educacion/edit-educacion.component';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { EditHysComponent } from './components/habilidades/edit-hys.component';
import { NewHysComponent } from './components/habilidades/new-hys.component';
import { EditHomeComponent } from './components/home/edit-home.component';
import { LoginComponent } from './components/login/login.component';
import { EditNavbarComponent } from './components/navbar/edit-navbar.component';
import { EditPerfilComponent } from './components/perfil/edit-perfil.component';
import { EditProyectoComponent } from './components/proyectos/edit-proyecto.component'; 
import { NewProyectoComponent } from './components/proyectos/new-proyecto.component';
 

const routes: Routes = [
{path:'', component: ApphomeComponent},
{path:'login', component: LoginComponent},
{path: 'nuevaexp', component: NewExperienciaComponent},
{path: 'editexp/:id', component: EditExperienciaComponent},
{path: 'nuevaedu', component: NewEducacionComponent},
{path: 'editedu/:id', component: EditEducacionComponent},
{path: 'nuevoskill', component: NewHysComponent},
{path: 'editskill/:id', component: EditHysComponent},
{path: 'nuevoproyec', component: NewProyectoComponent},
{path: 'editproyec/:id', component: EditProyectoComponent}, 
{path: 'editusuario/:id', component: EditHomeComponent}, 
{path: 'editusuarioperfil/:id', component: EditPerfilComponent}, 
{path: 'editusuarionavbar/:id', component: EditNavbarComponent}, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
