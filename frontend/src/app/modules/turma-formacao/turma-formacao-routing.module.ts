import { TurmaFormacaoFormComponent } from './turma-formacao-form/turma-formacao-form.component';
import { TurmaFormacaoListaComponent } from './turma-formacao-lista/turma-formacao-lista.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
    { path: '', component: TurmaFormacaoListaComponent },
    { path: 'novo', component: TurmaFormacaoFormComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TurmaFormacaoRoutingModule { }
