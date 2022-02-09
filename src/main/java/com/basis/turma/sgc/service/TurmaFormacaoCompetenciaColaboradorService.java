package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.repository.ColaboradorCompetenciaRepository;
import com.basis.turma.sgc.service.dto.colaboradorCompetencia.ColaboradorCompetenciaDTO;
import com.basis.turma.sgc.service.dto.colaboradorCompetencia.ColaboradorCompetenciaListaDTO;
import com.basis.turma.sgc.service.exception.RegraNegocio.Exception;
import com.basis.turma.sgc.service.mapper.colaboradorCompetencia.ColaboradorCompetenciaListaMapper;
import com.basis.turma.sgc.service.mapper.colaboradorCompetencia.ColaboradorCompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ColaboradorCompetenciaService {

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;
    private final ColaboradorCompetenciaMapper colaboradorCompetenciaMapper;
    private final ColaboradorCompetenciaListaMapper colaboradorCompetenciaListaMapper;

    public ColaboradorCompetenciaListaDTO buscar(Integer id) {
        ColaboradorCompetencia colaboradorCompetencia = colaboradorCompetenciaRepository.findById(id)
                .orElseThrow(() -> new Exception("Colaborador e Competencia não encontrados!"));

        return colaboradorCompetenciaListaMapper.paraDTO(colaboradorCompetencia);
    }

    public List<ColaboradorCompetenciaListaDTO> buscarTodas() {
        List<ColaboradorCompetencia> listaColaboradorCompetencia = colaboradorCompetenciaRepository.findAll();

        return colaboradorCompetenciaListaMapper.listaParaDTOs(listaColaboradorCompetencia);
    }

    public ColaboradorCompetenciaDTO inserir(ColaboradorCompetenciaDTO colaboradorCompetenciaDTO) {
        ColaboradorCompetencia colaboradorCompetencia = colaboradorCompetenciaMapper.paraEntidade(colaboradorCompetenciaDTO);
        colaboradorCompetencia = colaboradorCompetenciaRepository.save(colaboradorCompetencia);

        return colaboradorCompetenciaMapper.paraDTO(colaboradorCompetencia);
    }

    public ColaboradorCompetenciaDTO atualizar(ColaboradorCompetenciaDTO colaboradorCompetenciaDTO) {
        ColaboradorCompetencia colaboradorCompetencia = colaboradorCompetenciaMapper.paraEntidade(colaboradorCompetenciaDTO);
        colaboradorCompetencia = colaboradorCompetenciaRepository.save(colaboradorCompetencia);

        return colaboradorCompetenciaMapper.paraDTO(colaboradorCompetencia);
    }

    public void excluir(Integer id) {
        try {
            colaboradorCompetenciaRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Não foi possível deletar o colaborador e a competencia!");
        }
    }
}
