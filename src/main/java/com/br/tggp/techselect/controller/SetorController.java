package com.br.tggp.techselect.controller;

import com.br.tggp.techselect.dto.SetorRequest;
import com.br.tggp.techselect.dto.SetorResponse;
import com.br.tggp.techselect.service.SetorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/setor")
@RequiredArgsConstructor
public class SetorController {

    private final SetorService setorService;

    @PostMapping
    public ResponseEntity<SetorResponse> criarSetor(@RequestBody @Valid SetorRequest setorRequest){
        SetorResponse setorResponse = setorService.criarSetor(setorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(setorResponse);
    }

    @GetMapping("/recrutador/{idRecrutador}")
    public ResponseEntity<List<SetorResponse>> listarSetor(@PathVariable Long idRecrutador) {
        List<SetorResponse> setorResponse = setorService.listarSetores(idRecrutador);
        return ResponseEntity.status(HttpStatus.OK).body(setorResponse);
    }

    @DeleteMapping("/{idSetor}")
    public ResponseEntity deletarSetor(@PathVariable Long idSetor) {
        setorService.excluirSetor(idSetor);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
