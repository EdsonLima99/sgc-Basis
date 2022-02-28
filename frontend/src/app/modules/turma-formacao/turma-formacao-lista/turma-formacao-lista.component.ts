import { TurmaFormacaoService } from './../service/turma-formacao.service';
import { TurmaFormacaoModel } from './../models/turma_formacao.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-turma-formacao-lista',
  templateUrl: './turma-formacao-lista.component.html',
  styleUrls: ['./turma-formacao-lista.component.css']
})
export class TurmaFormacaoListaComponent implements OnInit {

    public COLUNA_NOME: string = 'Nome';
    public CAMPO_NOME: string = 'nome';

    public COLUNA_DATA_DE_INICIO: string = 'Data de Início';
    public CAMPO_DATA_DE_INICIO: string = 'dataInicio';

    public COLUNA_DATA_DE_TERMINO: string = 'Data de Término';
    public CAMPO_DATA_DE_TERMINO: string = 'dataTermino';

    public COLUNA_STATUS: string = 'Status';
    public CAMPO_STATUS: string = 'descricao';

    turmas: TurmaFormacaoModel[] = [];

    scrollableCols: any[];

    displayModal = false;

  constructor(private turmaFormacaoService: TurmaFormacaoService) { }

  ngOnInit(): void {

    this.buscarTodas();

        this.scrollableCols = [
            { field: this.CAMPO_NOME, header: this.COLUNA_NOME},
            { field: this.CAMPO_DATA_DE_INICIO, header: this.COLUNA_DATA_DE_INICIO},
            { field: this.CAMPO_DATA_DE_TERMINO, header: this.COLUNA_DATA_DE_TERMINO},
            { field: this.CAMPO_STATUS, header: this.COLUNA_STATUS}
        ]
    }

    public buscarTodas(){
        this.turmaFormacaoService.buscarTodas().subscribe(
            (turmas) => (this.turmas = turmas)
        )
    }

    public excluir(id: number){
        /*
        this.turmaFormacaoService.excluir(id).subscribe(() =>
        { alert('Turma de Formação Excluída!') },
        () => {alert('Não foi possível excluir a turma!'); })
        this.buscarTodas();
        */
        this.turmaFormacaoService.excluir(id).subscribe()
        alert('Turma de Formação Excluída!');
        this.buscarTodas();
    }

    showDialog() {
        this.displayModal = true;
    }
}
