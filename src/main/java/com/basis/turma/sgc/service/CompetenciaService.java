package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.repository.CompetenciaRepository;
import com.basis.turma.sgc.service.dto.CompetenciaDTO;
import com.basis.turma.sgc.service.exception.RegraNegocioException;
import com.basis.turma.sgc.service.mapper.CompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;
    private final CompetenciaMapper competenciaMapper;

    public CompetenciaDTO buscar(Integer id) {
        Competencia competencia = competenciaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Competência não encontrada!"));

        return competenciaMapper.paraDTO(competencia);
    }

    public CompetenciaDTO inserir(CompetenciaDTO competenciaDTO) {
        Competencia competencia = competenciaMapper.paraEntidade(competenciaDTO);
        competencia = competenciaRepository.save(competencia);

        return competenciaMapper.paraDTO(competencia);
    }
}
