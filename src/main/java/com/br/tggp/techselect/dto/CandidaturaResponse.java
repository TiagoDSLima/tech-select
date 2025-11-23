package com.br.tggp.techselect.dto;

import com.br.tggp.techselect.enums.Apto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidaturaResponse {

    private Long idCandidatura;
    private String nomeCompleto;
    private String email;
    private String telefone;
    private Integer exp;
    private Long idVaga;
    private List<SkillResponse> skills;
    private Apto apto;
}
