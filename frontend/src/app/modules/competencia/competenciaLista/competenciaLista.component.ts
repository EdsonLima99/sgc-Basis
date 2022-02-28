import { CompetenciaService } from './../service/competencia.service';
import { CompetenciaModel } from './../models/competencia.models';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-competenciaLista',
  templateUrl: './competenciaLista.component.html',
  styleUrls: ['./competenciaLista.component.css']
})
export class CompetenciaListaComponent implements OnInit {

    public COLUNA_CATEGORIA: string = "Categoria";
    public CAMPO_CATEGORIA: string = "descricao";

    competencias: CompetenciaModel[];
    compEdit: CompetenciaModel;

    scrollableCols: any[];

    displayModal: boolean = false;

  constructor(
      private listaCompetenciaService: CompetenciaService
  ) { }

  ngOnInit() {
    this.listarCompetencia()

    this.scrollableCols = [
        { field: 'nome', header: 'Nome' },
        { field: 'descricao', header: 'Descrição' },
        { field: this.CAMPO_CATEGORIA, header: this.COLUNA_CATEGORIA },
    ];
  }

  listarCompetencia(){
    this.listaCompetenciaService.listarCompetencias().subscribe((data)=>{
        this.competencias = data;
    },(error)=>{
        console.log("Erro.", error)
    })
  }

  showDialog() {
    this.compEdit = new CompetenciaModel()
    this.displayModal = true;
  }

  public deletarCompetencia(id: number){
    this.listaCompetenciaService.deletarCompetencia(id).subscribe()
    alert("Competência deletada.")
    this.listarCompetencia()
}

    public editarCompetencia(competencia: CompetenciaModel){
      this.compEdit = competencia;
      console.log(this.compEdit)
      this.showDialog();
    }

    public fecharModal(){
        this.displayModal = false
        this.compEdit = null
        this.listarCompetencia()
    }

}
