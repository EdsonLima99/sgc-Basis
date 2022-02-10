package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.repository.CompetenciaRepository;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaDTO;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaListaDTO;
import com.basis.turma.sgc.service.exception.regra.Exception;
import com.basis.turma.sgc.service.mapper.competencia.CompetenciaListaMapper;
import com.basis.turma.sgc.service.mapper.competencia.CompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;
    private final CompetenciaMapper competenciaMapper;
    private final CompetenciaListaMapper competenciaListaMapper;

    public CompetenciaListaDTO buscar(Integer id) {
        Competencia competencia = competenciaRepository.findById(id)
                .orElseThrow(() -> new Exception("Competência não encontrada!"));

        return competenciaListaMapper.paraDTO(competencia);
    }

    public List<CompetenciaListaDTO> buscarTodas() {
        List<Competencia> listaCompetencias = competenciaRepository.findAll();

        return competenciaListaMapper.listaParaDTOs(listaCompetencias);
    }

    public void inserir(CompetenciaDTO competenciaDTO) {
        Competencia competencia = competenciaMapper.paraEntidade(competenciaDTO);
        competenciaRepository.save(competencia);

    }

    public void atualizar(CompetenciaDTO competenciaDTO) {
        Competencia competencia = competenciaMapper.paraEntidade(competenciaDTO);
        competenciaRepository.save(competencia);

    }

    public void excluir(Integer id) {
        try {
            competenciaRepository.deleteById(id);
        } catch (java.lang.Exception e) {
            throw new Exception("Não foi possível excluir a competência!");
        }
    }
}
