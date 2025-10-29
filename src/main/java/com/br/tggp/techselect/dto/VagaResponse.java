package com.br.tggp.techselect.dto;

import com.br.tggp.techselect.enums.NivelExp;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VagaResponse {

    private Long idVaga;
    private NivelExp nivel;
    private Integer expMin;
    private String descricao;
    private Long idRecrutador;
    private List<SkillResponse> skills;
}
