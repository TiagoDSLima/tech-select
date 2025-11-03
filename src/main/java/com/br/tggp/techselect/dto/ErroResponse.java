package com.br.tggp.techselect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErroResponse {
    private String mensagem;
    private int status;
    private LocalDateTime horario;
}
