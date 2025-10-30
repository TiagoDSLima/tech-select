package com.br.tggp.techselect.service;

import com.br.tggp.techselect.dto.RecrutadorRequest;
import com.br.tggp.techselect.dto.RecrutadorResponse;
import com.br.tggp.techselect.repository.RecrutadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecrutadorService {

    private final RecrutadorRepository recrutadorRepository;
}
