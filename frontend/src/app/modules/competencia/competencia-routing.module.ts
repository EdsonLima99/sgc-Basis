import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompetenciaListaComponent } from './competenciaLista/competenciaLista.component';


const routes: Routes = [
    {path: '', component: CompetenciaListaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CompetenciaRoutingModule { }
