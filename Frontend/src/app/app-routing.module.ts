import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApphomeComponent } from './components/apphome/apphome.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
{path:"", component: ApphomeComponent},
{path:"login", component: LoginComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
