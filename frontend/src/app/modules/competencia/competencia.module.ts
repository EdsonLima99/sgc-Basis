import { SharedModule } from './../../shared/shared.module';
import { NgModule, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CompetenciaRoutingModule } from './competencia-routing.module';
import { CompetenciaListaComponent } from './competenciaLista/competenciaLista.component';
import { CompetenciaFormComponent } from './competenciaForm/competenciaForm.component';


@NgModule({
  declarations: [
      CompetenciaListaComponent,
      CompetenciaFormComponent,

  ],
  imports: [
    CommonModule,
    CompetenciaRoutingModule,
    SharedModule
  ]
})
export class CompetenciaModule { }
