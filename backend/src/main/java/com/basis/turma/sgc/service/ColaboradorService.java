package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.repository.ColaboradorCompetenciaRepository;
import com.basis.turma.sgc.repository.ColaboradorRepository;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorDTO;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorListaDTO;
import com.basis.turma.sgc.service.exception.regra.Exception;
import com.basis.turma.sgc.service.mapper.colabcomp.ColaborarCompetenciaMapper;
import com.basis.turma.sgc.service.mapper.colaborador.ColaboradorListaMapper;
import com.basis.turma.sgc.service.mapper.colaborador.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;
    private final ColaboradorMapper colaboradorMapper;
    private final ColaboradorListaMapper colaboradorListaMapper;
    private final ColaborarCompetenciaMapper colaborarCompetenciaMapper;
    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

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

        if(verificarEmailDuplicado(colaboradorDTO.getEmail())) {
            throw new Exception("Email já cadastrado!");
        }

        if(verificarCpfDuplicado(colaboradorDTO.getCpf())) {
            throw new Exception("CPF já cadastrado!");
        }

        Colaborador colaborador = colaboradorMapper.paraEntidade(colaboradorDTO);
        colaborador.setColaboradorCompetencias(new ArrayList<>());

        colaborador = colaboradorRepository.save(colaborador);

        for (int i = 0; i < colaboradorDTO.getColaboradorCompetencias().size(); i++) {
            colaboradorDTO.getColaboradorCompetencias().get(i).setColaboradorId(colaborador.getId());
            ColaboradorCompetencia colaboradorCompetencia = colaborarCompetenciaMapper.paraEntidade(colaboradorDTO.getColaboradorCompetencias().get(i));
            colaborador.getColaboradorCompetencias().add(colaboradorCompetencia);
        }

        colaboradorRepository.save(colaborador);

    }

    public void atualizar(ColaboradorDTO colaboradorDTO, Integer id) {

        if(verificarEmailDuplicado(colaboradorDTO.getEmail())) {
            throw new Exception("Email já cadastrado!");
        }

        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() -> new Exception("Colaborador não encontrado!"));

        Colaborador colab = colaboradorMapper.paraEntidade(colaboradorDTO);

        colaborador.setNome(colab.getNome());
        colaborador.setSobrenome(colab.getSobrenome());
        colaborador.setCpf(colab.getCpf());
        colaborador.setEmail(colab.getEmail());
        colaborador.setFoto(colab.getFoto());
        colaborador.setDataNascimento(colab.getDataNascimento());
        colaborador.setDataAdmissao(colab.getDataAdmissao());
        colaborador.setSenioridade(colab.getSenioridade());

        colaboradorRepository.save(colaborador);

        List<Integer> listaCompetenciaIds = colaboradorDTO.getColaboradorCompetencias().stream().map( idComp -> idComp.getCompetenciaId()).collect(Collectors.toList());

        List<ColaboradorCompetencia> listaColaboradorCompetencia = colaboradorCompetenciaRepository.findByColaboradorIdAndCompetenciaIdIn(id, listaCompetenciaIds);

        for (int i = 0; i < colaboradorDTO.getColaboradorCompetencias().size(); i++) {
            listaColaboradorCompetencia.get(i).setSenioridade(colaboradorDTO.getColaboradorCompetencias().get(i).getSenioridade());
        }

        colaboradorCompetenciaRepository.saveAll(listaColaboradorCompetencia);

    }

    public void excluir(Integer id) {

        try {
            colaboradorRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Não foi possível excluir o colaborador!");
        }
    }

    public boolean verificarEmailDuplicado(String email) {

        Colaborador colaborador = colaboradorRepository.findByEmail(email);
        return !(null == colaborador);
    }

    public boolean verificarCpfDuplicado(String cpf) {

        Colaborador colaborador = colaboradorRepository.findByCpf(cpf);
        return !(null == colaborador);
    }
}
