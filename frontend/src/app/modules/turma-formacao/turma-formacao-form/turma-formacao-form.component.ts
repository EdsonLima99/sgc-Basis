import { TurmaFormacaoCompetenciaColaboradorModel } from './../../turma-formacao-competencia-colaborador/models/turma-formacao-competencia-colaborador.model';
import { CompetenciaService } from './../../competencia/service/competencia.service';
import { ColaboradorModel } from './../../colaborador/models/colaborador.model';
import { CompetenciaModel } from './../../competencia/models/competencia.models';
import { ColaboradorService } from './../../colaborador/service/colaborador.service';
import { SelectItem } from 'primeng';
import { TurmaFormacaoService } from './../service/turma-formacao.service';
import { FormBuilder, Validators } from '@angular/forms';
import { SelecionaModel } from './../../seleciona/models/seleciona.models';
import { TurmaFormacaoModel } from './../models/turma_formacao.model';
import { FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { SelecionaService } from '../../seleciona/service/seleciona.service';

@Component({
  selector: 'app-turma-formacao-form',
  templateUrl: './turma-formacao-form.component.html',
  styleUrls: ['./turma-formacao-form.component.css']
})
export class TurmaFormacaoFormComponent implements OnInit {

    public COLUNA_NOME: string = 'Nome';
    public CAMPO_NOME: string = 'nome';

    public CAMPO_SOBRENOME: string = 'sobrenome';

    public COLUNA_EMAIL: string = 'E-mail';
    public CAMPO_EMAIL: string = 'email';

    public COLUNA_DATAADMISSAO: string = 'Data de Admissão';
    public CAMPO_DATAADMISSAO: string = 'dataAdmissao';

    public COLUNA_SENIORIDADE: string = "Senioridade";
    public CAMPO_SENIORIDADE: string = 'descricao';

    public formulario: FormGroup;

    turma: TurmaFormacaoModel[];
    status: SelecionaModel[] = [];
    opcoesCompetencia: SelecionaModel;
    competencias: CompetenciaModel[] = [];
    colaboradores: ColaboradorModel[] = [];
    //competenciaSelecionada: number;
    competenciaSelecionada: CompetenciaModel;
    colaboradorSelecionado: ColaboradorModel;
    colaboradorFiltrado: ColaboradorModel[] = [];
    competenciaBusca: CompetenciaModel;
    colaboradorBusca: ColaboradorModel;

    listaComp: CompetenciaModel[] = [];
    listColab: ColaboradorModel[] = [];

    turmaFormacaoCompetenciasColaboradores: TurmaFormacaoCompetenciaColaboradorModel[] = [];



  constructor(
    private formBuilder: FormBuilder,
    private turmaFormacaoService: TurmaFormacaoService,
    private competenciaService: CompetenciaService,
    private colaboradorService: ColaboradorService,
    private statusService: SelecionaService,
  ) {}

  ngOnInit(): void {
    this.listarStatus();
    this.listarCompetencias();
    //this.listarColaboradores();

    this.formulario = this.formBuilder.group({
        id: [null, Validators.required],
        nome: ["", [Validators.required, Validators.minLength(3), Validators.maxLength(35)]],
        descricao: ["", [Validators.required, Validators.minLength(3), Validators.maxLength(35)]],
        dataInicio: ["", Validators.required],
        dataTermino: ["", Validators.required],
        statusId: ["", Validators.required],
        //turmaFormacaoCompetenciasColaboradores: [[], Validators.required]
        turmaFormacaoCompetenciasColaboradores: [[], Validators.required]

    });
  }

  public listarCompetencias() {
    this.competenciaService.listarCompetencias().subscribe(
        (competencia: any) => {
            this.competencias = competencia;
        },
        (error) => {
            console.log("Erro.", error);
        }
    );

  }

  gerarNomeCompetencia(competenciaModel: TurmaFormacaoCompetenciaColaboradorModel) {
       let nomeComp = this.competencias.find((competencia) => competencia.id == competenciaModel.competenciaId).nome

       let nomeColab = this.colaboradores.find((colaborador) => colaborador.id == competenciaModel.colaboradorId).nome

       return nomeComp + " " + nomeColab;
  }

  /*
  public buscarCompetencia() {
    this.competenciaService.buscarCompetencia(this.competenciaSelecionada).subscribe(
        (competencia: any) => {
            this.competenciaBusca = competencia;
        },
        (error) => {
            console.log("Erro.", error);
        }
    );

  }
  */

  /*
  public buscarColaborador() {
    this.colaboradorService.buscar(this.colaboradorSelecionado).subscribe(
        (colaborador: any) => {
            this.competenciaBusca = colaborador;
        },
        (error) => {
            console.log("Erro.", error);
        }
    );

  }
  */


  public listarStatus() {
    this.statusService.getStatus().subscribe(
        (status: any) => {
            this.status = status;
        },
        (error) => {
            console.log("Erro.", error);
        }
    );

  }

  obterListaCompetencias() {
      return this.formulario.get('turmaFormacaoCompetenciasColaboradores').value
  }

  public listarColaboradores() {
    this.colaboradorService.buscarTodas().subscribe(
        (colaborador: any) => {
            this.colaboradores = colaborador;
        },
        (error) => {
            console.log("Erro.", error);
        }
    );

  }

  public listarColaboradoresCompetencia() {
    this.colaboradorService.buscarColaboradoresCompetencia(this.competenciaSelecionada.id).subscribe(
        (colaborador: any) => {
            this.colaboradores = colaborador;
        },
        (error) => {
            console.log("Erro.", error);
        }
    );

  }

  incluirCompetenciaTurma() {
    this.formulario.get('turmaFormacaoCompetenciasColaboradores').value.push(new TurmaFormacaoCompetenciaColaboradorModel(
        this.formulario.get('id').value,
        this.competenciaSelecionada.id,
        this.colaboradorSelecionado.id
    ))
    //console.log(this.formulario.get('turmaFormacaoCompetenciasColaboradores').value)
  }



    public inserir(){

        this.turmaFormacaoService.inserir(this.formulario.getRawValue()).subscribe(() => {

        })
        //this.formulario.get("turmaFormacaoCompetenciasColaboradores").setValue = turmaFormacaoCompetenciasColaboradores.;

        /*
        this.turmaFormacaoService.inserir(this.formulario.value).subscribe(
            resp =>  this.actionsForSucess(resp),
            error => this.actionsForError(error)
        )
        */
    }


    /*
    adicionarLista() {
        for(let i = 0; i < this.competencias.length; i++) {
            if(this.competenciaSelecionada === this.competencias[i].id) {
              //return this.competencias[i];
              this.listaComp.push(this.competencias[i]);
            }
        }
    */


        /*
        for(let i = 0; i < this.colaboradores.length; i++) {
            if(this.colaboradorSelecionado === this.colaboradores[i].id) {
                //return this.colaboradores[i];
                this.listColab.push(this.colaboradores[i]);
            }
        }
    }
    */


    converterDropdown(n: any[], valor: string, nome: string): SelectItem[] {
        return n.map((item: any) => ({
            value: valor ? item[valor] : item,
            label: item[nome],
        }));
    }

    converterDropdownColab(n: any[], valor: string, nome: string, sobrenome: string): SelectItem[] {
        return n.map((item: any) => ({
            value: valor ? item[valor] : item,
            label: item[nome] + " " + item[sobrenome],
        }));
    }

    teste() {
        //console.log(this.formulario.value);
        //console.log(this.formulario.get("turmaFormacaoCompetenciasColaboradores.competenciaId"));


    }

    onSubmit() {
        console.log(this.formulario);
    }


}
