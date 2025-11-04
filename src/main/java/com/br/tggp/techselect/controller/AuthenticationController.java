package com.br.tggp.techselect.controller;

import com.br.tggp.techselect.dto.LoginResponse;
import com.br.tggp.techselect.dto.RecrutadorRequest;
import com.br.tggp.techselect.dto.RecrutadorResponse;
import com.br.tggp.techselect.model.Recrutador;
import com.br.tggp.techselect.service.RecrutadorService;
import com.br.tggp.techselect.service.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final RecrutadorService recrutadorService;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid RecrutadorRequest recrutadorRequest){
        var loginSenha = new UsernamePasswordAuthenticationToken(recrutadorRequest.getEmail(), recrutadorRequest.getSenha());
        var auth = authenticationManager.authenticate(loginSenha);
        Recrutador recrutador = (Recrutador) auth.getPrincipal();
        var token = tokenService.gerarToken(recrutador);

        return ResponseEntity.ok(new LoginResponse(recrutador.getIdRecrutador(), token));
    }

    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<RecrutadorResponse> register(@ModelAttribute @Valid RecrutadorRequest recrutadorRequest){
        RecrutadorResponse recrutadorResponse = recrutadorService.criarRecrutador(recrutadorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(recrutadorResponse);
    }
}
