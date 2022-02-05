package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.service.CompetenciaService;
import com.basis.turma.sgc.service.dto.CompetenciaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/competencias")
@RequiredArgsConstructor
public class CompetenciaResource {

    private final CompetenciaService competenciaService;

    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaDTO> buscar(@PathVariable Integer id) {
        return new ResponseEntity<>(competenciaService.buscar(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompetenciaDTO> inserir(@RequestBody CompetenciaDTO competenciaDTO) {
        return new ResponseEntity<>(competenciaService.inserir(competenciaDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CompetenciaDTO> atualizar(@RequestBody CompetenciaDTO competenciaDTO) {
        return new ResponseEntity<>(competenciaService.atualizar(competenciaDTO), HttpStatus.OK);
    }

}