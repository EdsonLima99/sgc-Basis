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
@RequestMapping("/api/colaborador")
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
    public ResponseEntity<ColaboradorDTO> inserir(@RequestBody ColaboradorDTO colaboradorDTO) {
        return new ResponseEntity<>(colaboradorService.inserir(colaboradorDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ColaboradorDTO> atualizar(@RequestBody ColaboradorDTO colaboradorDTO) {
        return new ResponseEntity<>(colaboradorService.atualizar(colaboradorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        colaboradorService.excluir(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}