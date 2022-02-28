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


    // @Input() refreshGrid : boolean = false;

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

  atualizarLista(evento) {
    this.listarCompetencia();
}

  listarCompetencia(){
    this.listaCompetenciaService.listarCompetencias().subscribe((data)=>{
        this.competencias = data;
    },(error)=>{
        console.log("Erro.", error)
    })
  }


//   ngOnChanges(){
//     if(this.refreshGrid){
//       this.listarCompetencia();
//     }
//   }

  showDialog() {
    this.displayModal = true;
  }

//   atualizarLista($event:any){
//     this.refreshGrid = true;
//   }

  public deletarCompetencia(id: number){
    this.listaCompetenciaService.deletarCompetencia(id).subscribe()
    alert("Competência deletada.")
}

    public editarCompetencia(competencia: CompetenciaModel){
      this.compEdit = competencia;
      console.log(this.compEdit)
      this.showDialog();


        // this.listaCompetenciaService.editarCompetencia(id).subscribe()
    }

    public fecharModal(){
        this.displayModal = false
        this.compEdit = null
        this.listarCompetencia()
    }

}
