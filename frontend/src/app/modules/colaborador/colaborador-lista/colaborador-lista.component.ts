import { ColaboradorService } from "./../service/colaborador.service";
import { ColaboradorModel } from "./../models/colaborador.model";
import { Component, OnInit } from "@angular/core";

@Component({
    selector: "app-colaboradorLista",
    templateUrl: "./colaborador-lista.component.html",
    styleUrls: ["./colaborador-lista.component.css"],
})

export class ColaboradorListaComponent implements OnInit {

    public COLUNA_NOME: string = 'Nome';
    public CAMPO_NOME: string = 'nome';

    public CAMPO_SOBRENOME: string = 'sobrenome';

    public COLUNA_EMAIL: string = 'E-mail';
    public CAMPO_EMAIL: string = 'email';

    public COLUNA_DATAADMISSAO: string = 'Data de Admissão';
    public CAMPO_DATAADMISSAO: string = 'dataAdmissao';

    public COLUNA_SENIORIDADE: string = "Senioridade";
    public CAMPO_SENIORIDADE: string = 'descricao';


    colaboradores: ColaboradorModel[] = [];

    scrollableCols: any[];

    displayModal = false;

    constructor(private colaboradorService: ColaboradorService) {}

    ngOnInit() {
        this.buscarTodas();

        this.scrollableCols = [
            { field: this.CAMPO_NOME, header: this.COLUNA_NOME},
            { field: this.CAMPO_EMAIL, header: this.COLUNA_EMAIL},
            { field: this.CAMPO_DATAADMISSAO, header: this.COLUNA_DATAADMISSAO},
            { field: this.CAMPO_SENIORIDADE, header: this.COLUNA_SENIORIDADE}
        ]
    }

    public buscarTodas(){
        this.colaboradorService.buscarTodas().subscribe(
            (colaboradores) => (this.colaboradores = colaboradores)
        )
    }

    public excluir(id: number){
        this.colaboradorService.excluir(id).subscribe()
        alert("Colaborador excluído")
    }

    showDialog() {
        this.displayModal = true;
      }
}
