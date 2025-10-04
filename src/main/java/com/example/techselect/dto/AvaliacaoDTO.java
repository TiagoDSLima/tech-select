package com.example.techselect.dto;

import com.example.techselect.enums.Apto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoDTO {
    private Long idAvaliacao;
    private CandidatoDTO candidato;
    private LocalDateTime data;
    private Apto apto;
}
