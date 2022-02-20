package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.service.CategoriaService;
import com.basis.turma.sgc.service.dto.SelecionaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaResource {

    private final CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<SelecionaDTO> buscar(@PathVariable Integer id) {
        return new ResponseEntity<>(categoriaService.buscar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SelecionaDTO>> buscarTodas() {
        return new ResponseEntity<>(categoriaService.buscarTodas(), HttpStatus.OK);
    }
}
