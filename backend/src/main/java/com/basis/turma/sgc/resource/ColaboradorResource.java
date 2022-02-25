package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.repository.ColaboradorRepository;
import com.basis.turma.sgc.service.ColaboradorService;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorDTO;
import com.basis.turma.sgc.service.dto.colaborador.ColaboradorListaDTO;
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
@RequestMapping("/api/colaboradores")
@RequiredArgsConstructor
public class ColaboradorResource {

    private final ColaboradorService colaboradorService;
    private final ColaboradorRepository colaboradorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorListaDTO> buscar(@PathVariable Integer id) {
        return new ResponseEntity<>(colaboradorService.buscar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorListaDTO>> buscarTodos() {
        return new ResponseEntity<>(colaboradorService.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@Valid @RequestBody ColaboradorDTO colaboradorDTO) {
        colaboradorService.inserir(colaboradorDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@Valid @RequestBody ColaboradorDTO colaboradorDTO, @PathVariable Integer id) {
        colaboradorService.atualizar(colaboradorDTO, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        Optional<Colaborador> colaboradorOptional = colaboradorService.buscarPorId(id);
        if(!colaboradorOptional.isPresent()) {
            throw new Exception("Colaborador não encontrado!");
        }

        try {
            colaboradorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new Exception("Não foi possível excluir o colaborador!");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}