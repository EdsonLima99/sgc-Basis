import { SelecionaModel } from "../../seleciona/models/seleciona.models";

export class CompetenciaModel {
    id: number;
    nome: string;
    descricao: string;
    categoriaId: SelecionaModel;
}
