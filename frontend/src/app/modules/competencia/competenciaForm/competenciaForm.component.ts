import { CompetenciaService } from './../service/competencia.service';
import { Observable } from 'rxjs';
import { CategoriaService } from './../service/categoria.service';
import { SelecionaModel } from './../../seleciona/models/seleciona.models';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { SelectItem } from 'primeng';
import { CompetenciaModel } from '../models/competencia.models';


@Component({
  selector: 'app-competenciaForm',
  templateUrl: './competenciaForm.component.html',
  styleUrls: ['./competenciaForm.component.css']
})
export class CompetenciaFormComponent implements OnInit {

    // @Output() atualizarLista = new EventEmitter();

     public formulario: FormGroup;

     categorias: SelecionaModel[] = [];
     competencia: CompetenciaModel[];
     @Input() compEdit: CompetenciaModel;
     @Output() public aoFechar: EventEmitter<void> = new EventEmitter()


  constructor(
      private formBuilder: FormBuilder,
      private listaCategoriaService: CategoriaService,
      private competenciaService: CompetenciaService
  ) { }

  ngOnInit(){
    this.listarCategoria()
      this.formulario = this.formBuilder.group({
          id: [null],
          nome: ['',[Validators.required]],
          descricao: ['', [Validators.required]],
          categoriaId:['', [Validators.required]]
      });
      if (!!this.compEdit){
          this.formulario.patchValue(this.compEdit)
          this.formulario.get("categoriaId").setValue(this.compEdit.categoria.id)
        //   console.log(this.formulario.getRawValue())
      }
    //   console.log("isso: " + this.compEdit)
    };

    converterDropdown(categorias: any[], valor:string, nome:string): SelectItem[]{
        return categorias.map((item:any) => ({
            value: item[valor],
            label: item[nome]
        }));
    }

    public salvarCompetencia(){
        console.log("teste");
        this.competenciaService.inserirCompetencia(this.formulario.getRawValue()).subscribe(() => {
            this.fecharModal()
        })
    }

    public editarCompetencia(){
        this.competenciaService.editarCompetencia(this.formulario.get('id').value, this.formulario.getRawValue()).subscribe(() => {
            this.fecharModal()
        })
    }

    verificarId() {
        if (!this.formulario.get("id").value) {
            this.salvarCompetencia();
            return;
        }
        this.editarCompetencia();
    }

    verificaValidacao(campo){
        return this.formulario.get(campo).valid && this.formulario.get(campo).touched;
    }

    erroCss(campo){
        return{
            'has-error': this.verificaValidacao(campo),
            'has-feedback': this.verificaValidacao(campo)
        }
    }

    public fecharModal(){
        this.aoFechar.emit()
    }

    public listarCategoria(){
        this.listaCategoriaService.getCategorias().subscribe((categorias:any)=>{
            this.categorias = categorias;
        },(error)=>{
            console.log("Erro.", error)
        })
      }

    //   get title() {
    //     return this.titleModal? "Criar competência" : "Editar competência";
    // }
 }
