package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.repository.TurmaFormacaoCompetenciaColaboradorRepository;
import com.basis.turma.sgc.repository.TurmaFormacaoRepository;
import com.basis.turma.sgc.service.TurmaFormacaoService;
import com.basis.turma.sgc.service.dto.turma.TurmaFormacaoDTO;
import com.basis.turma.sgc.service.dto.turma.TurmaFormacaoListaDTO;
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
@RequestMapping("/api/turmas_formacao")
@RequiredArgsConstructor
public class TurmaFormacaoResource {

    private final TurmaFormacaoService turmaFormacaoService;
    private final TurmaFormacaoRepository turmaFormacaoRepository;
    private final TurmaFormacaoCompetenciaColaboradorRepository turmaFormacaoCompetenciaColaboradorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<TurmaFormacaoListaDTO> buscar(@PathVariable Integer id){
        return new ResponseEntity<>(turmaFormacaoService.buscar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TurmaFormacaoListaDTO>> buscarTodas() {
        return new ResponseEntity<>(turmaFormacaoService.buscarTodas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@Valid @RequestBody TurmaFormacaoDTO turmaFormacaoDTO) {
        turmaFormacaoService.inserir(turmaFormacaoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@Valid @RequestBody TurmaFormacaoDTO turmaFormacaoDTO, @PathVariable Integer id) {
        turmaFormacaoService.atualizar(turmaFormacaoDTO, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id){
        turmaFormacaoService.excluir(id);
//        Optional<TurmaFormacao> turmaFormacaoOptional = turmaFormacaoService.buscarPorId(id);
//        if(!turmaFormacaoOptional.isPresent()) {
//            throw new Exception("Turma não encontrada!");
//        }
//
//        List<TurmaFormacaoCompetenciaColaborador> lista = turmaFormacaoCompetenciaColaboradorRepository.findByTurmaFormacaoId(id);
//        turmaFormacaoCompetenciaColaboradorRepository.deleteAll(lista);
//
//
//        try {
//            turmaFormacaoRepository.deleteById(id);
//        } catch (DataIntegrityViolationException e) {
//            throw new Exception("Não foi possível excluir a turma!");
//        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
