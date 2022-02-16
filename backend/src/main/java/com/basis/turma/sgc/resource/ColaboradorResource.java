package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.service.ColaboradorService;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorDTO;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorListaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colaboradores")
@RequiredArgsConstructor
public class ColaboradorResource {

    private final ColaboradorService colaboradorService;

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorListaDTO> buscar(@PathVariable Integer id) {
        return new ResponseEntity<>(colaboradorService.buscar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorListaDTO>> buscarTodas() {
        return new ResponseEntity<>(colaboradorService.buscarTodas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody ColaboradorDTO colaboradorDTO) {
        colaboradorService.inserir(colaboradorDTO);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody ColaboradorDTO colaboradorDTO, @PathVariable Integer id) {
        colaboradorService.atualizar(colaboradorDTO, id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        colaboradorService.excluir(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}