package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.service.StatusService;
import com.basis.turma.sgc.service.dto.SelecionaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
public class StatusResource {

    private final StatusService statusService;

    @GetMapping("/{id}")
    public ResponseEntity<SelecionaDTO> buscar(@PathVariable Integer id){
        return new ResponseEntity<>(statusService.buscar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SelecionaDTO>> buscarTodos() {
        return new ResponseEntity<>(statusService.buscarTodos(), HttpStatus.OK);
    }

}
