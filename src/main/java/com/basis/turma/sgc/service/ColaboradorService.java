package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.repository.ColaboradorCompetenciaRepository;
import com.basis.turma.sgc.repository.ColaboradorRepository;
import com.basis.turma.sgc.service.dto.SelecionaDTO;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorDTO;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorIdNomeListaDTO;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorListaDTO;
import com.basis.turma.sgc.service.exception.regra.Exception;
import com.basis.turma.sgc.service.mapper.colabcomp.ColaborarCompetenciaMapper;
import com.basis.turma.sgc.service.mapper.colaborador.ColaboradorListaMapper;
import com.basis.turma.sgc.service.mapper.colaborador.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorMapper colaboradorMapper;
    private final ColaborarCompetenciaMapper colaborarCompetenciaMapper;
    private final ColaboradorListaMapper colaboradorListaMapper;
    private final ColaboradorRepository colaboradorRepository;
    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    public ColaboradorListaDTO buscar(Integer id) {
        Optional<Colaborador> colaboradorOptional = buscarPorId(id);
        if(!colaboradorOptional.isPresent()) {
            throw new Exception("Colaborador não encontrado!");
        }
        return colaboradorListaMapper.paraDTO(colaboradorOptional.get());
    }

    public List<ColaboradorListaDTO> buscarTodos() {
        List<Colaborador> lista = colaboradorRepository.findAll();
        return colaboradorListaMapper.listaParaDTOs(lista);
    }

    public void inserir(ColaboradorDTO colaboradorDTO) {
        if(verificarCpfDuplicado(colaboradorDTO.getCpf())) {
            throw new Exception("Cpf já cadastrado no sistema!");
        }

        if(verificarEmailDuplicado(colaboradorDTO.getEmail())) {
            throw new Exception("Email já cadastrado no sistema!");
        }

        Colaborador colaborador = colaboradorMapper.paraEntidade(colaboradorDTO);
        colaborador = colaboradorRepository.save(colaborador);
        int colaboradorId = colaborador.getId();
        List<ColaboradorCompetencia> lista = colaboradorDTO.getColaboradorCompetencias().stream().map( c -> {
            c.setColaboradorId(colaboradorId);
            return colaborarCompetenciaMapper.paraEntidade(c);
        }).collect(Collectors.toList());
        colaboradorCompetenciaRepository.saveAll(lista);
    }

    public void atualizar(ColaboradorDTO colaboradorDTO, Integer id) {
        Optional<Colaborador> colaboradorOptional = buscarPorId(id);
        if(!colaboradorOptional.isPresent()) {
            throw new Exception("Colaborador não encontrado!");
        }
        colaboradorDTO.setId(id);
        Colaborador colaborador = colaboradorMapper.paraEntidade(colaboradorDTO);
        List<ColaboradorCompetencia> lista = colaboradorDTO.getColaboradorCompetencias().stream().map( c -> {
            c.setColaboradorId(colaborador.getId());
            return colaborarCompetenciaMapper.paraEntidade(c);
        }).collect(Collectors.toList());
        colaboradorRepository.save(colaborador);
        colaboradorCompetenciaRepository.saveAll(lista);
    }

    public Optional<Colaborador> buscarPorId(Integer id) {
        return colaboradorRepository.findById(id);
    }

    public List<ColaboradorIdNomeListaDTO> buscarColaboradoresCompetencia(Integer competenciaId) {
        List<ColaboradorCompetencia> lista = colaboradorCompetenciaRepository.findByCompetenciaIdAndSenioridade(competenciaId, 3);
        List<ColaboradorIdNomeListaDTO> listaDTO = lista.stream().map( c -> {
            ColaboradorIdNomeListaDTO dto = new ColaboradorIdNomeListaDTO();
            dto.setId(c.getColaborador().getId());
            dto.setNomeSobrenome(c.getColaborador().getNome() + " " + c.getColaborador().getSobrenome());
            return dto;
        }).collect(Collectors.toList());

        return listaDTO;
    }

    public boolean verificarEmailDuplicado(String email) {
        Colaborador colaborador = colaboradorRepository.findByEmail(email);
        return null != colaborador;
    }

    public boolean verificarCpfDuplicado(String cpf) {
        Colaborador colaborador = colaboradorRepository.findByCpf(cpf);
        return null != colaborador;
    }
}
