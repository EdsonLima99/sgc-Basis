package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.repository.ColaboradorCompetenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/colaborador_competencias")
@RequiredArgsConstructor
public class ColaboradorCompetenciaResource {

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    @DeleteMapping("/{colaboradorId}/{competenciaId}")
    public ResponseEntity<Void> excluir(@PathVariable Integer colaboradorId, @PathVariable Integer competenciaId) {
        ColaboradorCompetencia colaboradorCompetencia = colaboradorCompetenciaRepository.findByColaboradorIdAndCompetenciaId(colaboradorId, competenciaId);
        colaboradorCompetenciaRepository.delete(colaboradorCompetencia);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
