import { ColaboradorCompetenciaModel } from "../../colaborador-competencia/models/colaborador-competencia.model";
import { SelecionaModel } from "../../seleciona/models/seleciona.models";

export class ColaboradorModel{
    id: number;
    nome: string;
    sobrenome: string;
    cpf: string;
    email: string;
    foto: File;
    datanascimento: Date;
    dataadmissao: Date;
    senioridadeId: SelecionaModel;
    colaboradorCompetencias: ColaboradorCompetenciaModel[];
}
