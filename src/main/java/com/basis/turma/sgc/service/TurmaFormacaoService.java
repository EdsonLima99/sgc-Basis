package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.repository.TurmaFormacaoRepository;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaDTO;
import com.basis.turma.sgc.service.dto.turma.TurmaFormacaoDTO;
import com.basis.turma.sgc.service.dto.turma.TurmaFormacaoListaDTO;
import com.basis.turma.sgc.service.exception.RegraNegocioException;
import com.basis.turma.sgc.service.mapper.turma.TurmaFormacaoMapper;
import com.basis.turma.sgc.service.mapper.turma.TurmaFormacaoListaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TurmaFormacaoService {

    private final TurmaFormacaoMapper turmaFormacaoMapper;
    private final TurmaFormacaoRepository turmaFormacaoRepository;
    private final TurmaFormacaoListaMapper turmaFormacaoListaMapper;

    public TurmaFormacaoDTO inserir(TurmaFormacaoDTO turmaFormacaoDTO) {
        TurmaFormacao turmaFormacao = turmaFormacaoMapper.paraEntidade(turmaFormacaoDTO);
        turmaFormacao = turmaFormacaoRepository.save(turmaFormacao);

        return turmaFormacaoMapper.paraDTO(turmaFormacao);
    }

    public TurmaFormacaoListaDTO buscarPorId(Integer id){
        TurmaFormacao turmaFormacao = turmaFormacaoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Turma não encontrada"));

        return turmaFormacaoListaMapper.paraDTO(turmaFormacao);
    }

    public List<TurmaFormacaoListaDTO> buscarTodas() {
        List<TurmaFormacao> listaTurmas= turmaFormacaoRepository.findAll();

        return turmaFormacaoListaMapper.listaParaDTOs(listaTurmas);
    }

    public TurmaFormacaoDTO atualizar(TurmaFormacaoDTO turmaFormacaoDTO) {
            TurmaFormacao turmaFormacao = turmaFormacaoMapper.paraEntidade(turmaFormacaoDTO);
        turmaFormacao = turmaFormacaoRepository.save(turmaFormacao);

        return turmaFormacaoMapper.paraDTO(turmaFormacao);
    }

    public void excluir(Integer id) {
        try {
            turmaFormacaoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RegraNegocioException("Não foi possível deletar a competência");
        }
    }

}

