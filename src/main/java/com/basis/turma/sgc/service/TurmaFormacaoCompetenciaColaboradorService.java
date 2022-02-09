package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.repository.TurmaFormacaoCompetenciaColaboradorRepository;
import com.basis.turma.sgc.service.dto.turmaFormacaoCompetenciaColaborador.TurmaFormacaoCompetenciaColaboradorDTO;
import com.basis.turma.sgc.service.dto.turmaFormacaoCompetenciaColaborador.TurmaFormacaoCompetenciaColaboradorListaDTO;
import com.basis.turma.sgc.service.exception.RegraNegocio.Exception;
import com.basis.turma.sgc.service.mapper.turmaFormacaoCompetenciaColaborador.TurmaFormacaoCompetenciaColaboradorListaMapper;
import com.basis.turma.sgc.service.mapper.turmaFormacaoCompetenciaColaborador.TurmaFormacaoCompetenciaColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TurmaFormacaoCompetenciaColaboradorService {

    private final TurmaFormacaoCompetenciaColaboradorRepository turmaFormacaoCompetenciaColaboradorRepository;
    private final TurmaFormacaoCompetenciaColaboradorMapper turmaFormacaoCompetenciaColaboradorMapper;
    private final TurmaFormacaoCompetenciaColaboradorListaMapper turmaFormacaoCompetenciaColaboradorListaMapper;

    public TurmaFormacaoCompetenciaColaboradorListaDTO buscar(Integer id) {
        TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador = turmaFormacaoCompetenciaColaboradorRepository.findById(id)
                .orElseThrow(() -> new Exception("Turma de Formação, Colaborador e Competencia não encontrados!"));

        return turmaFormacaoCompetenciaColaboradorListaMapper.paraDTO(turmaFormacaoCompetenciaColaborador);
    }

    public List<TurmaFormacaoCompetenciaColaboradorListaDTO> buscarTodas() {
        List<TurmaFormacaoCompetenciaColaborador> listaTurmaFormacaoCompetenciaColaborador = turmaFormacaoCompetenciaColaboradorRepository.findAll();

        return turmaFormacaoCompetenciaColaboradorListaMapper.listaParaDTOs(listaTurmaFormacaoCompetenciaColaborador);
    }

    public TurmaFormacaoCompetenciaColaboradorDTO inserir(TurmaFormacaoCompetenciaColaboradorDTO turmaFormacaoCompetenciaColaboradorDTO) {
        TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador = turmaFormacaoCompetenciaColaboradorMapper.paraEntidade(turmaFormacaoCompetenciaColaboradorDTO);
        turmaFormacaoCompetenciaColaborador = turmaFormacaoCompetenciaColaboradorRepository.save(turmaFormacaoCompetenciaColaborador);

        return turmaFormacaoCompetenciaColaboradorMapper.paraDTO(turmaFormacaoCompetenciaColaborador);
    }

    public TurmaFormacaoCompetenciaColaboradorDTO atualizar(TurmaFormacaoCompetenciaColaboradorDTO turmaFormacaoCompetenciaColaboradorDTO) {
        TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador = turmaFormacaoCompetenciaColaboradorMapper.paraEntidade(turmaFormacaoCompetenciaColaboradorDTO);
        turmaFormacaoCompetenciaColaborador = turmaFormacaoCompetenciaColaboradorRepository.save(turmaFormacaoCompetenciaColaborador);

        return turmaFormacaoCompetenciaColaboradorMapper.paraDTO(turmaFormacaoCompetenciaColaborador);
    }

    public void excluir(Integer id) {
        try {
            turmaFormacaoCompetenciaColaboradorRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Não foi possível deletar o colaborador e a competencia!");
        }
    }
}
