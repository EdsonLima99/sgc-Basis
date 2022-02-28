import { SelecionaModel } from "../../seleciona/models/seleciona.models";

export class CompetenciaModel {
    //id: number;
    //nome: string;
    //descricao: string;
    //categoriaId: SelecionaModel;
    constructor(
        public id?: number,
        public nome?: string,
        public descricao?: string,
        public categoriaId: SelecionaModel = new SelecionaModel()
    ){}
}
