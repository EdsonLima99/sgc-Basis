import { TurmaFormacaoModule } from './modules/turma-formacao/turma-formacao.module';
import { TurmaFormacaoModel } from './modules/turma-formacao/models/turma_formacao.model';
import { ColaboradorModule } from './modules/colaborador/colaborador.module';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import { CompetenciaListaComponent } from './modules/competencia/competenciaLista/competenciaLista.component';
import { CompetenciaModule } from './modules/competencia/competencia.module';

const routes: Routes = [
    { path: 'diario-erros', component: DiarioErrosComponent, data: { breadcrumb: 'Diário de Erros'} },
    { path: 'login-success', component: LoginSuccessComponent },
    { path: 'competencia', loadChildren: () => CompetenciaModule },
    { path: 'colaboradores', loadChildren: () => ColaboradorModule },
    { path: 'turmas_formacao', loadChildren: () => TurmaFormacaoModule },
    { path: '', redirectTo: 'colaboradores', pathMatch: 'full'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
