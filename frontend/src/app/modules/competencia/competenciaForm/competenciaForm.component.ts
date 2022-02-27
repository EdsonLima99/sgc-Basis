import { CompetenciaService } from './../service/competencia.service';
import { Observable } from 'rxjs';
import { CategoriaService } from './../service/categoria.service';
import { SelecionaModel } from './../../seleciona/models/seleciona.models';
import { Component, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup} from '@angular/forms';
import { SelectItem } from 'primeng';
import { CompetenciaModel } from '../models/competencia.models';
// import { EventEmitter } from 'protractor';

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


  constructor(
      private formBuilder: FormBuilder,
      private listaCategoriaService: CategoriaService,
      private competenciaService: CompetenciaService
  ) { }

  ngOnInit(){
    this.listarCategoria()
      this.formulario = this.formBuilder.group({
          id: [null],
          nome: [''],
          descricao: [''],
          categoriaId:['']
      });
      if (!!this.compEdit){
          this.formulario.patchValue(this.compEdit)
      }
      console.log("isso: " + this.compEdit)
    };

    converterDropdown(categorias: any[], valor:string, nome:string): SelectItem[]{
        return categorias.map((item:any) => ({
            value: item[valor],
            label: item[nome]
        }));
    }

    public salvarCompetencia(){
        console.log("teste");
        this.competenciaService.inserirCompetencia(this.formulario.getRawValue()).subscribe()
        // this.atualizarLista.emit("atualizar")

    }

    public listarCategoria(){
        this.listaCategoriaService.getCategorias().subscribe((categorias:any)=>{
            this.categorias = categorias;
        },(error)=>{
            console.log("Erro.", error)
        })
      }

//       enviarReq(observable: Observable<CompetenciaModel>) {
//         observable.subscribe((result) => {
//             this.atualizarLista.emit("Atualizar")
//         });
// }
 }
