package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.repository.TurmaFormacaoCompetenciaColaboradorRepository;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TurmaFormacaoService {

    private final TurmaFormacaoMapper turmaFormacaoMapper;
    private final TurmaFormacaoCompetenciaColaboradorMapper turmaFormacaoCompetenciaColaboradorMapper;
    private final TurmaFormacaoListaMapper turmaFormacaoListaMapper;
    private final TurmaFormacaoRepository turmaFormacaoRepository;
    private final TurmaFormacaoCompetenciaColaboradorRepository turmaFormacaoCompetenciaColaboradorRepository;

    public TurmaFormacaoListaDTO buscar(Integer id){
        Optional<TurmaFormacao> turmaFormacaoOptional = buscarPorId(id);
        if(!turmaFormacaoOptional.isPresent()) {
            throw new Exception("Turma não encontrada!");
        }
        return turmaFormacaoListaMapper.paraDTO(turmaFormacaoOptional.get());
    }

    public List<TurmaFormacaoListaDTO> buscarTodas() {
        List<TurmaFormacao> lista = turmaFormacaoRepository.findAll();
        return turmaFormacaoListaMapper.listaParaDTOs(lista);
    }

    public void inserir(TurmaFormacaoDTO turmaFormacaoDTO) {
        TurmaFormacao turmaFormacao = turmaFormacaoMapper.paraEntidade(turmaFormacaoDTO);
        turmaFormacao = turmaFormacaoRepository.save(turmaFormacao);
        int turmaFormacaoId = turmaFormacao.getId();
        List<TurmaFormacaoCompetenciaColaborador> lista = turmaFormacaoDTO.getTurmaFormacaoCompetenciasColaboradores()
                .stream().map(t -> {
                    t.setTurmaFormacaoId(turmaFormacaoId);
                    return turmaFormacaoCompetenciaColaboradorMapper.paraEntidade(t);
                }).collect(Collectors.toList());
        turmaFormacaoCompetenciaColaboradorRepository.saveAll(lista);
    }


    public void atualizar(TurmaFormacaoDTO turmaFormacaoDTO, Integer id) {
        Optional<TurmaFormacao> turmaFormacaoOptional = buscarPorId(id);
        if(!turmaFormacaoOptional.isPresent()) {
            throw new Exception("Turma não encontrada!");
        }
        turmaFormacaoDTO.setId(id);
        TurmaFormacao turmaFormacao = turmaFormacaoMapper.paraEntidade(turmaFormacaoDTO);
        List<TurmaFormacaoCompetenciaColaborador> lista = turmaFormacaoDTO.getTurmaFormacaoCompetenciasColaboradores()
                .stream().map(t -> {
                    t.setTurmaFormacaoId(turmaFormacao.getId());
                    return turmaFormacaoCompetenciaColaboradorMapper.paraEntidade(t);
                }).collect(Collectors.toList());
        turmaFormacaoRepository.save(turmaFormacao);
        turmaFormacaoCompetenciaColaboradorRepository.saveAll(lista);
    }

    public void excluir(Integer id) {
        Optional<TurmaFormacao> turmaFormacaoOptional = buscarPorId(id);
        if(!turmaFormacaoOptional.isPresent()) {
            throw new Exception("Turma não encontrada!");
        }

        List<TurmaFormacaoCompetenciaColaborador> lista = turmaFormacaoCompetenciaColaboradorRepository.findByTurmaFormacaoId(id);
        turmaFormacaoCompetenciaColaboradorRepository.deleteAll(lista);
        turmaFormacaoRepository.deleteById(id);
    }

    public Optional<TurmaFormacao> buscarPorId(Integer id) {
        return turmaFormacaoRepository.findById(id);
    }

}

