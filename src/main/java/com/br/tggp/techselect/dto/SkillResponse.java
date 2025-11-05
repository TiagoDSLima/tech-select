package com.br.tggp.techselect.dto;

import com.br.tggp.techselect.enums.NivelSkill;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillResponse {

    private Long idSkill;
    private String descricao;
    private NivelSkill nivel;
    private Long idVaga;
    private Long idCandidatura;
}
