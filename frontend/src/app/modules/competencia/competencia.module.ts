import { CategoriaService } from './service/categoria.service';
import { CompetenciaService } from './service/competencia.service';
import { DropdownModule } from 'primeng/dropdown';
import { SharedModule } from './../../shared/shared.module';
import { NgModule, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ButtonModule } from 'primeng/button'
import { CompetenciaRoutingModule } from './competencia-routing.module';
import { CompetenciaListaComponent } from './competenciaLista/competenciaLista.component';
import { CompetenciaFormComponent } from './competenciaForm/competenciaForm.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
      CompetenciaListaComponent,
      CompetenciaFormComponent
  ],
  imports: [
    CommonModule,
    CompetenciaRoutingModule,
    SharedModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    DropdownModule
  ],
  providers:[
      CompetenciaService,
      CategoriaService
  ]
})
export class CompetenciaModule { }
