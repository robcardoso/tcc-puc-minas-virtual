import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', loadChildren:()=> import('./home/home.module').then((m)=>m.HomeModule) },
  { path: 'agenda-consultas', loadChildren:()=> import('./agenda-consultas/agenda-consultas.module').then((m)=>m.AgendaConsultasModule) },

  { path: '**', redirectTo: 'home'}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
