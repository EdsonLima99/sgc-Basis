package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.service.CompetenciaService;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaDTO;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaListaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/competencias")
@RequiredArgsConstructor
public class CompetenciaResource {

    private final CompetenciaService competenciaService;

    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaListaDTO> buscar(@PathVariable Integer id) {
        return new ResponseEntity<>(competenciaService.buscar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CompetenciaListaDTO>> buscarTodas() {
        return new ResponseEntity<>(competenciaService.buscarTodas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@Valid @RequestBody CompetenciaDTO competenciaDTO) {
        competenciaService.inserir(competenciaDTO);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@Valid @RequestBody CompetenciaDTO competenciaDTO) {
        competenciaService.atualizar(competenciaDTO);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        competenciaService.excluir(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}