package com.br.tggp.techselect.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecrutadorResponse {

    private Long idRecrutador;
    private String email;
    private String nomeEmpresa;
    private String urlLogo;
    private String nomeCompleto;
}