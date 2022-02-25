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
    private final StatusListaMapper statusListaMapper;
    private final StatusRepository statusRepository;

    public SelecionaDTO buscar(Integer id){
        Status status = statusRepository.findById(id)
                .orElseThrow(() -> new Exception("Status não encontrado!"));
        return statusMapper.paraDTO(status);
    }

    public List<SelecionaDTO> buscarTodos() {
        List<Status> lista = statusRepository.findAll();
        return statusListaMapper.listaParaDTOs(lista);
    }
}

