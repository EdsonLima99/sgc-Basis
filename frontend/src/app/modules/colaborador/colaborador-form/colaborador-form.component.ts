import { ColaboradorCompetenciaModel } from './../../colaborador-competencia/models/colaborador-competencia.model';
import { CompetenciaModel } from './../../competencia/models/competencia.models';
import { CompetenciaService } from './../../competencia/service/competencia.service';
import { SelecionaService } from "./../../seleciona/service/seleciona.service";
import { ColaboradorService } from "./../service/colaborador.service";
import { ColaboradorModel } from "./../models/colaborador.model";
import { SelecionaModel } from "./../../seleciona/models/seleciona.models";
import { Component, OnInit } from "@angular/core";
import { SelectItem } from "primeng";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";

@Component({
    selector: "app-colaborador-form",
    templateUrl: "./colaborador-form.component.html",
    styleUrls: ["./colaborador-form.component.css"],
})
export class ColaboradorFormComponent implements OnInit {
    public formulario: FormGroup;

    senioridade: SelecionaModel[] = [];
    colaborador: ColaboradorModel[];
    competencia: CompetenciaModel[] = [];
    competenciaSelecionada: CompetenciaModel;
    nivelSelecionado: SelecionaModel;

    constructor(
        private formBuilder: FormBuilder,
        private senioridadeService: SelecionaService,
        private colaboradorService: ColaboradorService,
        private competenciaService: CompetenciaService
    ) {}

    ngOnInit(): void {
        this.listarSenioridade();
        this.listarCompetencia();

        this.formulario = this.formBuilder.group({
            id: [null],
            nome: [null, [Validators.required, Validators.minLength(3)]],
            sobrenome: [null, [Validators.required, Validators.minLength(3)]],
            cpf: [null, [Validators.required, Validators.minLength(11)]],
            email: [null, [Validators.required, Validators.email]],
            foto: [null],
            dataNascimento: [null, Validators.required],
            dataAdmissao: [null, Validators.required],
            senioridadeId: [null, Validators.required],
            colaboradorCompetencias:[[], Validators.required]
        });
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
            value: valor ? item[valor]: item,
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

    public listarCompetencia() {
        this.competenciaService.listarCompetencias().subscribe(
            (competencia: any) => {
                this.competencia = competencia;
            },
            (error) => {
                console.log("Erro.", error);
            }
        );
    }

    incluirColaboradorCompetencia(){
        this.formulario.get('colaboradorCompetencias').value.push(new ColaboradorCompetenciaModel(
            this.formulario.get('id').value,
            this.competenciaSelecionada.id,
            this.nivelSelecionado.id
        ))
        console.log(this.competenciaSelecionada),
        console.log(this.nivelSelecionado)
    }

    obterListaColaboradorCompetencias(){
        return this.formulario.get('colaboradorCompetencias').value;
    }

    gerarCompetenciasSenioridade(colaboradorCompetencia: ColaboradorCompetenciaModel){
        return this.competenciaSelecionada.nome + " " + this.nivelSelecionado.descricao;
    }
}
