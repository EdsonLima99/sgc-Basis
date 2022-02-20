import { ColaboradorService } from "./../service/colaborador.service";
import { ColaboradorModel } from "./../models/colaborador.model";
import { Component, OnInit } from "@angular/core";

@Component({
    selector: "app-colaboradorLista",
    templateUrl: "./colaborador-lista.component.html",
    styleUrls: ["./colaborador-lista.component.css"],
})
export class ColaboradorListaComponent implements OnInit {
    colaboradores: ColaboradorModel[] = [];

    constructor(private colaboradorService: ColaboradorService) {}

    ngOnInit() {
        this.colaboradorService.buscarTodas().subscribe(
            (colaboradores) => (this.colaboradores = colaboradores),
            (error) => alert("Error ao carregar a página")
        )

    }
}
