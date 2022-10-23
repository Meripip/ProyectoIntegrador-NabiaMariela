import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PerfilComponent } from './components/perfil/perfil.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { HabilidadesComponent } from './components/habilidades/habilidades.component';
import { ProyectosComponent } from './components/proyectos/proyectos.component';
import { LoginComponent } from './components/login/login.component';
import { ContactoComponent } from './components/contacto/contacto.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { FooterComponent } from './components/footer/footer.component';
import {HttpClientModule} from "@angular/common/http";
import { ApphomeComponent } from './components/apphome/apphome.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { EditEducacionComponent } from './components/educacion/edit-educacion.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NewHysComponent } from './components/habilidades/new-hys.component';
import { EditHysComponent } from './components/habilidades/edit-hys.component';
import { NewProyectoComponent } from './components/proyectos/new-proyecto.component';
import { EditProyectoComponent } from './components/proyectos/edit-proyecto.component';
import { EditHomeComponent } from './components/home/edit-home.component';
import { EditPerfilComponent } from './components/perfil/edit-perfil.component';
import { EditNavbarComponent } from './components/navbar/edit-navbar.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    PerfilComponent,
    ExperienciaComponent,
    EducacionComponent,
    HabilidadesComponent,
    ProyectosComponent,
    LoginComponent,
    ContactoComponent,
    FooterComponent,
    ApphomeComponent,
    NewEducacionComponent,
    EditEducacionComponent,
    NewExperienciaComponent,
    EditExperienciaComponent,
    NewHysComponent,
    EditHysComponent,
    NewProyectoComponent,
    EditProyectoComponent,
    EditHomeComponent,
    EditPerfilComponent,
    EditNavbarComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({}),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
