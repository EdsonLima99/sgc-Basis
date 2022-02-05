package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.service.CompetenciaService;
import com.basis.turma.sgc.service.dto.CompetenciaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/competencia")
@RequiredArgsConstructor
public class CompetenciaResource {

    private final CompetenciaService competenciaService;

    @PostMapping
    public ResponseEntity<CompetenciaDTO> inserir(@RequestBody CompetenciaDTO competenciaDTO) {
        return new ResponseEntity<>(competenciaService.inserir(competenciaDTO), HttpStatus.CREATED);
    }

}