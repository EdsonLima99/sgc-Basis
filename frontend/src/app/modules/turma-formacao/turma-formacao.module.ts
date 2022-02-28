import { DropdownModule } from 'primeng/dropdown';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TurmaFormacaoRoutingModule } from './turma-formacao-routing.module';
import { TurmaFormacaoListaComponent } from './turma-formacao-lista/turma-formacao-lista.component';
import { TurmaFormacaoFormComponent } from './turma-formacao-form/turma-formacao-form.component';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [TurmaFormacaoListaComponent, TurmaFormacaoFormComponent],
  imports: [
    CommonModule,
    TurmaFormacaoRoutingModule,
    SharedModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    DropdownModule
  ]
})
export class TurmaFormacaoModule { }
