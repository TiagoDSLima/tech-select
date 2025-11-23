package com.br.tggp.techselect.controller;

import com.br.tggp.techselect.dto.VagaRequest;
import com.br.tggp.techselect.dto.VagaResponse;
import com.br.tggp.techselect.service.VagaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vaga")
@RequiredArgsConstructor
public class VagaController {

    private final VagaService vagaService;

    @PostMapping
    public ResponseEntity<VagaResponse> criarVaga(@RequestBody @Valid VagaRequest vagaRequest) {
        VagaResponse vagaResponse = vagaService.cadastrarVaga(vagaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(vagaResponse);
    }

    @GetMapping("/recrutador/{idRecrutador}")
    public ResponseEntity<List<VagaResponse>> listarVagas(@PathVariable Long idRecrutador) {
        List<VagaResponse> vagasResponse =  vagaService.listarVagas(idRecrutador);
        return ResponseEntity.status(HttpStatus.OK).body(vagasResponse);
    }

    @PutMapping("/{idVaga}")
    private ResponseEntity<VagaResponse> atualizarVaga(@PathVariable Long idVaga, @RequestBody @Valid VagaRequest vagaRequest) {
        VagaResponse vagaResponse = vagaService.atualizarVaga(vagaRequest, idVaga);
        return ResponseEntity.status(HttpStatus.OK).body(vagaResponse);
    }

    @DeleteMapping("/{idVaga}")
    private ResponseEntity deletarVaga(@PathVariable Long idVaga) {
        vagaService.deletarVaga(idVaga);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
