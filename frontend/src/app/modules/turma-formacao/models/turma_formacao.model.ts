import { SelecionaModel } from "../../seleciona/models/seleciona.models";
import { TurmaFormacaoCompetenciaColaboradorModel } from "../../turma-formacao-competencia-colaborador/models/turma-formacao-competencia-colaborador.model";

export class TurmaFormacaoModel {
    id: number;
    nome: string;
    descricao: string;
    dataInicio: Date;
    dataTermino: Date;
    statusId: SelecionaModel;
    turmaFormacaoCompetenciasColaboradores: TurmaFormacaoCompetenciaColaboradorModel[];
}
