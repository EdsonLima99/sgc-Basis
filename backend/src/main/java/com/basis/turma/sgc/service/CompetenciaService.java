package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.repository.ColaboradorCompetenciaRepository;
import com.basis.turma.sgc.repository.CompetenciaRepository;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaDTO;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaListaDTO;
import com.basis.turma.sgc.service.exception.regra.Exception;
import com.basis.turma.sgc.service.mapper.competencia.CompetenciaListaMapper;
import com.basis.turma.sgc.service.mapper.competencia.CompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompetenciaService {

    private final CompetenciaMapper competenciaMapper;
    private final CompetenciaListaMapper competenciaListaMapper;
    private final CompetenciaRepository competenciaRepository;
    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    public CompetenciaListaDTO buscar(Integer id) {
        Optional<Competencia> competenciaOptional = buscarPorId(id);
        if(!competenciaOptional.isPresent()) {
            throw new Exception("Competência não encontrada!");
        }
        return competenciaListaMapper.paraDTO(competenciaOptional.get());
    }

    public List<Integer> buscarPorColaborador(Integer id) {
        return colaboradorCompetenciaRepository.buscarPorColaborador(id);
    }

    public List<CompetenciaListaDTO> buscarTodas() {
        List<Competencia> lista = competenciaRepository.findAll();
        return competenciaListaMapper.listaParaDTOs(lista);
    }

    public void inserir(CompetenciaDTO competenciaDTO) {
        Competencia competencia = competenciaMapper.paraEntidade(competenciaDTO);
        competenciaRepository.save(competencia);
    }

    public void atualizar(CompetenciaDTO competenciaDTO, Integer id) {
        Optional<Competencia> competenciaOptional = buscarPorId(id);
        if(!competenciaOptional.isPresent()) {
            throw new Exception("Competência não encontrada!");
        }
        competenciaDTO.setId(id);
        Competencia competencia = competenciaMapper.paraEntidade(competenciaDTO);
        competenciaRepository.save(competencia);
    }

    public Optional<Competencia> buscarPorId(Integer id) {
        return competenciaRepository.findById(id);
    }

}
