package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.repository.TurmaFormacaoRepository;
import com.basis.turma.sgc.service.dto.turma.TurmaFormacaoDTO;
import com.basis.turma.sgc.service.dto.turma.TurmaFormacaoListaDTO;
import com.basis.turma.sgc.service.exception.regra.Exception;
import com.basis.turma.sgc.service.mapper.turma.TurmaFormacaoMapper;
import com.basis.turma.sgc.service.mapper.turma.TurmaFormacaoListaMapper;
import com.basis.turma.sgc.service.mapper.turmacompcolab.TurmaFormacaoCompetenciaColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TurmaFormacaoService {

    private final TurmaFormacaoMapper turmaFormacaoMapper;
    private final TurmaFormacaoRepository turmaFormacaoRepository;
    private final TurmaFormacaoListaMapper turmaFormacaoListaMapper;
    private final TurmaFormacaoCompetenciaColaboradorMapper turmaFormacaoCompetenciaColaboradorMapper;

    public void inserir(TurmaFormacaoDTO turmaFormacaoDTO) {

        TurmaFormacao turmaFormacao = turmaFormacaoMapper.paraEntidade(turmaFormacaoDTO);
        turmaFormacao.setTurmaFormacaoCompetenciasColaboradores(new ArrayList<>());

        turmaFormacao = turmaFormacaoRepository.save(turmaFormacao);

        for(int i = 0; i < turmaFormacaoDTO.getTurmaFormacaoCompetenciasColaboradores().size(); i++) {
            turmaFormacaoDTO.getTurmaFormacaoCompetenciasColaboradores().get(i).setTurmaFormacaoId(turmaFormacao.getId());
            TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador = turmaFormacaoCompetenciaColaboradorMapper.paraEntidade(turmaFormacaoDTO.getTurmaFormacaoCompetenciasColaboradores().get(i));
            turmaFormacao.getTurmaFormacaoCompetenciasColaboradores().add(turmaFormacaoCompetenciaColaborador);
        }

        turmaFormacaoRepository.save(turmaFormacao);

    }

    public TurmaFormacaoListaDTO buscarPorId(Integer id){

        TurmaFormacao turmaFormacao = turmaFormacaoRepository.findById(id)
                .orElseThrow(() -> new Exception("Turma não encontrada!"));

        return turmaFormacaoListaMapper.paraDTO(turmaFormacao);
    }

    public List<TurmaFormacaoListaDTO> buscarTodas() {

        List<TurmaFormacao> listaTurmas= turmaFormacaoRepository.findAll();

        return turmaFormacaoListaMapper.listaParaDTOs(listaTurmas);
    }

    public void atualizar(TurmaFormacaoDTO turmaFormacaoDTO, Integer id) {

        TurmaFormacao turmaFormacao = turmaFormacaoRepository.findById(id)
                .orElseThrow(() -> new Exception("Turma não encontrada!"));

        TurmaFormacao turma = turmaFormacaoMapper.paraEntidade(turmaFormacaoDTO);

       turmaFormacao.setNome(turma.getNome());
       turmaFormacao.setDescricao(turma.getDescricao());
       turmaFormacao.setDataInicio(turma.getDataInicio());
       turmaFormacao.setDataTermino(turma.getDataTermino());
       turmaFormacao.setStatus(turma.getStatus());

       turmaFormacaoRepository.save(turmaFormacao);

    }

    public void excluir(Integer id) {

        try {
            turmaFormacaoRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Não foi possível excluir a turma!");
        }
    }

}

