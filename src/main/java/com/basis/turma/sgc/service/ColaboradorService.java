package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.repository.ColaboradorRepository;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorDTO;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorListaDTO;
import com.basis.turma.sgc.service.exception.regra.Exception;
import com.basis.turma.sgc.service.mapper.colaborador.ColaboradorListaMapper;
import com.basis.turma.sgc.service.mapper.colaborador.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;
    private final ColaboradorMapper colaboradorMapper;
    private final ColaboradorListaMapper colaboradorListaMapper;

    public ColaboradorListaDTO buscar(Integer id) {
        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() -> new Exception("Colaborador não encontrado!"));

        return colaboradorListaMapper.paraDTO(colaborador);
    }

    public List<ColaboradorListaDTO> buscarTodas() {
        List<Colaborador> listaColaborador = colaboradorRepository.findAll();

        return colaboradorListaMapper.listaParaDTOs(listaColaborador);
    }

    public void inserir(ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = colaboradorMapper.paraEntidade(colaboradorDTO);
        colaboradorRepository.save(colaborador);

    }

    public void atualizar(ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = colaboradorMapper.paraEntidade(colaboradorDTO);
        colaboradorRepository.save(colaborador);
    }

    public void excluir(Integer id) {
        try {
            colaboradorRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Não foi possível deletar o colaborador!");
        }
    }
}
