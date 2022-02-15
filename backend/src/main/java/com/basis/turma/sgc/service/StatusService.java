package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.Status;
import com.basis.turma.sgc.repository.StatusRepository;
import com.basis.turma.sgc.service.dto.SelecionaDTO;
import com.basis.turma.sgc.service.exception.regra.Exception;
import com.basis.turma.sgc.service.mapper.status.StatusListaMapper;
import com.basis.turma.sgc.service.mapper.status.StatusMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StatusService {

    private final StatusMapper statusMapper;
    private final StatusRepository statusRepository;
    private final StatusListaMapper statusListaMapper;

    public SelecionaDTO buscarPorId(Integer id){
        Status status = statusRepository.findById(id)
                .orElseThrow(() -> new Exception("Turma não encontrada"));

        return statusMapper.paraDTO(status);
    }

    public List<SelecionaDTO> buscarTodas() {
        List<Status> listaStatus= statusRepository.findAll();

        return statusListaMapper.listaParaDTOs(listaStatus);
    }
}

