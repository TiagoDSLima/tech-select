package com.br.tggp.techselect.controller;

import com.br.tggp.techselect.dto.CandidaturaRequest;
import com.br.tggp.techselect.dto.CandidaturaResponse;
import com.br.tggp.techselect.service.CandidaturaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidatura")
@RequiredArgsConstructor
public class CandidaturaController {

    private final CandidaturaService candidaturaService;

    @PostMapping
    public ResponseEntity<CandidaturaResponse> criarCandidatura(@RequestBody @Valid CandidaturaRequest candidaturaRequest) {
        CandidaturaResponse candidaturaResponse = candidaturaService.criarCandidatura(candidaturaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidaturaResponse);
    }

    @GetMapping("/recrutador/{idRecrutador}")
    public ResponseEntity<List<CandidaturaResponse>> listarCandidaturas(@PathVariable long idRecrutador) {
        List<CandidaturaResponse> candidaturasResponse = candidaturaService.listarCandidaturas(idRecrutador);
        return ResponseEntity.ok(candidaturasResponse);
    }
}
