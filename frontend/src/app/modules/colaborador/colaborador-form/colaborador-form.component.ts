import { SelecionaModel } from './../../seleciona/models/seleciona.models';
import { Component, OnInit } from '@angular/core';
import {DropdownModule} from 'primeng/dropdown';

@Component({
  selector: 'app-colaborador-form',
  templateUrl: './colaborador-form.component.html',
  styleUrls: ['./colaborador-form.component.css']
})

export class ColaboradorFormComponent implements OnInit {

  ngOnInit(): void {
  }
    senioridade: SelecionaModel[];

    selecionarSenioridade: SelecionaModel;

    constructor() {
        this.senioridade = [
            {descricao: 'Estagiário', id: 1},
            {descricao: 'Júnior', id: 2},
            {descricao: 'Pleno', id: 3},
            {descricao: 'Sênior', id: 4}
        ];
    }

}
