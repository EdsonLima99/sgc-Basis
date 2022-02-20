package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.service.TurmaFormacaoService;
import com.basis.turma.sgc.service.dto.turma.TurmaFormacaoDTO;
import com.basis.turma.sgc.service.dto.turma.TurmaFormacaoListaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas_formacao")
@RequiredArgsConstructor
public class TurmaFormacaoResource {

    private final TurmaFormacaoService turmaFormacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<TurmaFormacaoListaDTO> buscarPorId(@PathVariable Integer id){
        return new ResponseEntity<>(turmaFormacaoService.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TurmaFormacaoListaDTO>> buscarTodas() {
        return new ResponseEntity<>(turmaFormacaoService.buscarTodas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody TurmaFormacaoDTO turmaFormacaoDTO) {
        turmaFormacaoService.inserir(turmaFormacaoDTO);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody TurmaFormacaoDTO turmaFormacaoDTO, @PathVariable Integer id) {
        turmaFormacaoService.atualizar(turmaFormacaoDTO, id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        turmaFormacaoService.excluir(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }



}
