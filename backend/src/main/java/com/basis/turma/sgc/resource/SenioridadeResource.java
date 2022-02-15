package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.service.SenioridadeService;
import com.basis.turma.sgc.service.dto.SelecionaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/senioridades")
@RequiredArgsConstructor
public class SenioridadeResource {

    private final SenioridadeService senioridadeService;

    @GetMapping("/{id}")
    public ResponseEntity<SelecionaDTO> buscar(@PathVariable Integer id) {
        return new ResponseEntity<>(senioridadeService.buscar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SelecionaDTO>> buscarTodas() {
        return new ResponseEntity<>(senioridadeService.buscarTodas(), HttpStatus.OK);
    }

}