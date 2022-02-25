import { SelecionaModel } from "./../../seleciona/models/seleciona.models";
import { Component, OnInit } from "@angular/core";

@Component({
    selector: "app-colaborador-alterar",
    templateUrl: "./colaborador-alterar.component.html",
    styleUrls: ["./colaborador-alterar.component.css"],
})
export class ColaboradorAlterarComponent implements OnInit {

    ngOnInit(): void {}

    senioridade: SelecionaModel[];

    selecionarSenioridade: SelecionaModel;

    constructor() {
        this.senioridade = [
            { descricao: "Estagiário", id: 1 },
            { descricao: "Júnior", id: 2 },
            { descricao: "Pleno", id: 3 },
            { descricao: "Sênior", id: 4 },
        ];
    }
}
