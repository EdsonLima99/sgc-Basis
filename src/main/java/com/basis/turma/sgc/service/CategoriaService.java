package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.Categoria;
import com.basis.turma.sgc.repository.CategoriaRepository;
import com.basis.turma.sgc.service.dto.SelecionaDTO;
import com.basis.turma.sgc.service.exception.regra.Exception;
import com.basis.turma.sgc.service.mapper.categoria.CategoriaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaMapper categoriaMapper;
    private final CategoriaRepository categoriaRepository;

    public SelecionaDTO buscar(Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new Exception("Categoria não encontrada!"));

        return categoriaMapper.paraDTO(categoria);
    }

    public List<SelecionaDTO> buscarTodas() {
        List<Categoria> listaCategorias = categoriaRepository.findAll();

        return categoriaMapper.listaParaDTOs(listaCategorias);
    }
}
