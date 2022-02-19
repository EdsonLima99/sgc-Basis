import { CompetenciaService } from './../service/competencia.service';
import { CompetenciaModel } from './../models/competencia.models';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-competenciaLista',
  templateUrl: './competenciaLista.component.html',
  styleUrls: ['./competenciaLista.component.css']
})
export class CompetenciaListaComponent implements OnInit {

    competencias: CompetenciaModel[];

    scrollableCols: any[];

  constructor(
      private listaCompetenciaService: CompetenciaService
  ) { }

  ngOnInit() {
    this.listarCompetencia()

    this.scrollableCols = [
        { field: 'nome', header: 'Nome' },
        { field: 'descricao', header: 'Descrição' },
        { field: 'categoriaId', header: 'Categoria' },
    ];
  }

  listarCompetencia(){
    this.listaCompetenciaService.listarCompetencias().subscribe((data)=>{
        this.competencias = data;
    },(error)=>{
        console.log("Erro.", error)
    })
  }
}
