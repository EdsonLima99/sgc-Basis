import { SelecionaService } from "./../../seleciona/service/seleciona.service";
import { ColaboradorService } from "./../service/colaborador.service";
import { ColaboradorModel } from "./../models/colaborador.model";
import { SelecionaModel } from "./../../seleciona/models/seleciona.models";
import { Component, OnInit } from "@angular/core";
import { SelectItem } from "primeng";
import { FormBuilder, FormGroup } from "@angular/forms";

@Component({
    selector: "app-colaborador-form",
    templateUrl: "./colaborador-form.component.html",
    styleUrls: ["./colaborador-form.component.css"],
})
export class ColaboradorFormComponent implements OnInit {
    public formulario: FormGroup;

    senioridade: SelecionaModel[] = [];
    colaborador: ColaboradorModel[];

    constructor(
        private formBuilder: FormBuilder,
        private senioridadeService: SelecionaService,
        private colaboradorService: ColaboradorService
    ) {}

    ngOnInit(): void {
        this.listarSenioridade();

        this.formulario = this.formBuilder.group({
            id: [null],
            nome: [""],
            sobrenome: [""],
            cpf: [""],
            email: [""],
            foto: [],
            dataNascimento: [""],
            dataAdmissao: [""],
            senioridadeId: [],
            // colaboradorCompetencias:[]
            colaboradorCompetencias: {
                competenciaId: {},
                senioridade: {},
            },
        });

        // this.listaCategoriaService.getCategorias().subscribe((data:any)=>{
        //     this.categorias=data;
        // });
    }

    public Salvar() {
        console.log(this.formulario);
        this.colaboradorService
            .inserir(this.formulario.getRawValue())
            .subscribe();
    }

    public Cancelar() {}

    converterDropdown(n: any[], valor: string, nome: string): SelectItem[] {
        return n.map((item: any) => ({
            value: item[valor],
            label: item[nome],
        }));
    }

    public listarSenioridade() {
        this.senioridadeService.getSenioridade().subscribe(
            (senioridade: any) => {
                this.senioridade = senioridade;
            },
            (error) => {
                console.log("Erro.", error);
            }
        );
    }
}
