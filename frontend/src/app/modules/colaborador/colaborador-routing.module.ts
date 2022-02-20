import { ColaboradorAlterarComponent } from './colaborador-alterar/colaborador-alterar.component';
import { ColaboradorFormComponent } from './colaborador-form/colaborador-form.component';
import { ColaboradorListaComponent } from './colaborador-lista/colaborador-lista.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
    {path: '', component: ColaboradorListaComponent},
    {path: 'novo', component: ColaboradorFormComponent},
    {path: 'alterar/:id', component: ColaboradorAlterarComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ColaboradorRoutingModule { }
