import { SelecionaService } from './../seleciona/service/seleciona.service';
import { ColaboradorService } from './service/colaborador.service';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { ColaboradorFormComponent } from './colaborador-form/colaborador-form.component';
import { ColaboradorListaComponent } from './colaborador-lista/colaborador-lista.component';
import { SharedModule } from './../../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ColaboradorRoutingModule } from './colaborador-routing.module';
import { ColaboradorAlterarComponent } from './colaborador-alterar/colaborador-alterar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
      ColaboradorListaComponent,
      ColaboradorFormComponent,
      ColaboradorAlterarComponent
    ],
    imports: [
    CommonModule,
    ColaboradorRoutingModule,
    SharedModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    DropdownModule
  ],
  providers:[
      ColaboradorService,
      SelecionaService
  ]
})
export class ColaboradorModule { }
