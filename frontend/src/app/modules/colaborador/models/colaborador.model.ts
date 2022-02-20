import { ColaboradorCompetenciaModel } from "../../colaborador-competencia/models/colaborador-competencia.model";
import { SelecionaModel } from "../../seleciona/models/seleciona.models";

export class ColaboradorModel {
    constructor(
        public id: number,
        public nome: string,
        public sobrenome: string,
        public cpf: string,
        public email: string,
        public foto: File,
        public datanascimento: Date,
        public dataadmissao: Date,
        public senioridadeId: SelecionaModel,
        public colaboradorCompetencias: ColaboradorCompetenciaModel[]
    ) {}
}
