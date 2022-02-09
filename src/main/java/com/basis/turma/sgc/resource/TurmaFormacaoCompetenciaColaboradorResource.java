package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.service.ColaboradorCompetenciaService;
import com.basis.turma.sgc.service.dto.colaboradorCompetencia.ColaboradorCompetenciaDTO;
import com.basis.turma.sgc.service.dto.colaboradorCompetencia.ColaboradorCompetenciaListaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colaboradorCompetencia")
@RequiredArgsConstructor
public class ColaboradorCompetenciaResource {

    private final ColaboradorCompetenciaService colaboradorCompetenciaService;

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorCompetenciaListaDTO> buscar(@PathVariable Integer id) {
        return new ResponseEntity<>(colaboradorCompetenciaService.buscar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorCompetenciaListaDTO>> buscarTodas() {
        return new ResponseEntity<>(colaboradorCompetenciaService.buscarTodas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ColaboradorCompetenciaDTO> inserir(@RequestBody ColaboradorCompetenciaDTO colaboradorCompetenciaDTO) {
        return new ResponseEntity<>(colaboradorCompetenciaService.inserir(colaboradorCompetenciaDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ColaboradorCompetenciaDTO> atualizar(@RequestBody ColaboradorCompetenciaDTO colaboradorCompetenciaDTO) {
        return new ResponseEntity<>(colaboradorCompetenciaService.atualizar(colaboradorCompetenciaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        colaboradorCompetenciaService.excluir(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}