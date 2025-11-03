package com.br.tggp.techselect.dto;

import com.br.tggp.techselect.enums.Apto;
import com.br.tggp.techselect.model.Candidatura;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CandidaturaResponse {

    private Long idCandidatura;
    private String nomeCompleto;
    private String email;
    private String telefone;
    private Integer exp;
    private String urlCurriculo;
    private Long idVaga;
    private List<SkillResponse> skills;
    private Apto apto;

    public CandidaturaResponse(Long idCandidatura, String nomeCompleto, String email, String telefone,
                               Integer exp, String urlCurriculo, Long idVaga,
                               List<SkillResponse> skills) {
        this.idCandidatura = idCandidatura;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.telefone = telefone;
        this.exp = exp;
        this.urlCurriculo = urlCurriculo;
        this.idVaga = idVaga;
        this.skills = skills;
    }
}
