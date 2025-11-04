package com.br.tggp.techselect.controller;

import com.br.tggp.techselect.dto.SetorRequest;
import com.br.tggp.techselect.dto.SetorResponse;
import com.br.tggp.techselect.service.SetorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setor")
@RequiredArgsConstructor
public class SetorController {

    private final SetorService setorService;

    @PostMapping
    public ResponseEntity<SetorResponse> criarSetor(@RequestBody SetorRequest setorRequest){}
}
