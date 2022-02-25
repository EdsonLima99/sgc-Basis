package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.repository.CompetenciaRepository;
import com.basis.turma.sgc.service.CompetenciaService;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaDTO;
import com.basis.turma.sgc.service.dto.competencia.CompetenciaListaDTO;
import com.basis.turma.sgc.service.exception.regra.Exception;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/competencias")
@RequiredArgsConstructor
public class CompetenciaResource {

    private final CompetenciaService competenciaService;
    private final CompetenciaRepository competenciaRepository;

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
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@Valid @RequestBody CompetenciaDTO competenciaDTO, @PathVariable Integer id ) {
        competenciaService.atualizar(competenciaDTO, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        Optional<Competencia> competenciaOptional = competenciaService.buscarPorId(id);
        if(!competenciaOptional.isPresent()) {
            throw new Exception("Competência não encontrada!");
        }

        try {
            competenciaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new Exception("Não foi possível excluir a competência!");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}