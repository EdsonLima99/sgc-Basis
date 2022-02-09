package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.service.TurmaFormacaoCompetenciaColaboradorService;
import com.basis.turma.sgc.service.dto.turmaFormacaoCompetenciaColaborador.TurmaFormacaoCompetenciaColaboradorDTO;
import com.basis.turma.sgc.service.dto.turmaFormacaoCompetenciaColaborador.TurmaFormacaoCompetenciaColaboradorListaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmaFormacaoCompetenciaColaborador")
@RequiredArgsConstructor
public class TurmaFormacaoCompetenciaColaboradorResource {

    private final TurmaFormacaoCompetenciaColaboradorService turmaFormacaoCompetenciaColaboradorService;

    @GetMapping("/{id}")
    public ResponseEntity<TurmaFormacaoCompetenciaColaboradorListaDTO> buscar(@PathVariable Integer id) {
        return new ResponseEntity<>(turmaFormacaoCompetenciaColaboradorService.buscar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TurmaFormacaoCompetenciaColaboradorListaDTO>> buscarTodas() {
        return new ResponseEntity<>(turmaFormacaoCompetenciaColaboradorService.buscarTodas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TurmaFormacaoCompetenciaColaboradorDTO> inserir(@RequestBody TurmaFormacaoCompetenciaColaboradorDTO turmaFormacaoCompetenciaColaboradorDTO) {
        return new ResponseEntity<>(turmaFormacaoCompetenciaColaboradorService.inserir(turmaFormacaoCompetenciaColaboradorDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TurmaFormacaoCompetenciaColaboradorDTO> atualizar(@RequestBody TurmaFormacaoCompetenciaColaboradorDTO turmaFormacaoCompetenciaColaboradorDTO) {
        return new ResponseEntity<>(turmaFormacaoCompetenciaColaboradorService.atualizar(turmaFormacaoCompetenciaColaboradorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        turmaFormacaoCompetenciaColaboradorService.excluir(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}