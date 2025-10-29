package com.br.tggp.techselect.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetorResponse {

    private Long idSetor;
    private String nome;
    private Long idRecrutador;
}
