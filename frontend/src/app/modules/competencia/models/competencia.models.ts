import { SelecionaModel } from './../../seleciona/models/seleciona.models';
export class CompetenciaModel {
    constructor(
        public id?: number,
        public nome?: string,
        public descricao?: string,
        public categoria: SelecionaModel = new SelecionaModel()
    ){}
}
