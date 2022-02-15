package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.Senioridade;
import com.basis.turma.sgc.repository.SenioridadeRepository;
import com.basis.turma.sgc.service.dto.SelecionaDTO;
import com.basis.turma.sgc.service.exception.regra.Exception;
import com.basis.turma.sgc.service.mapper.senioridade.SenioridadeListaMapper;
import com.basis.turma.sgc.service.mapper.senioridade.SenioridadeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SenioridadeService {

    private final SenioridadeRepository senioridadeRepository;
    private final SenioridadeMapper senioridadeMapper;
    private final SenioridadeListaMapper senioridadeListaMapper;

    public SelecionaDTO buscar(Integer id) {
        Senioridade senioridade = senioridadeRepository.findById(id)
                .orElseThrow(() -> new Exception("Senioridade não encontrada!"));

        return senioridadeListaMapper.paraDTO(senioridade);
    }

    public List<SelecionaDTO> buscarTodas() {
        List<Senioridade> listaSenioridade = senioridadeRepository.findAll();

        return senioridadeListaMapper.listaParaDTOs(listaSenioridade);
    }
}
