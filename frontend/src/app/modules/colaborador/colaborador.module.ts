import { ColaboradorFormComponent } from './colaborador-form/colaborador-form.component';
import { ColaboradorListaComponent } from './colaborador-lista/colaborador-lista.component';
import { SharedModule } from './../../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ColaboradorRoutingModule } from './colaborador-routing.module';
import { ColaboradorAlterarComponent } from './colaborador-alterar/colaborador-alterar.component';


@NgModule({
  declarations: [
      ColaboradorListaComponent,
      ColaboradorFormComponent,
      ColaboradorAlterarComponent
    ],
    imports: [
    CommonModule,
    ColaboradorRoutingModule,
    SharedModule
  ]
})
export class ColaboradorModule { }
