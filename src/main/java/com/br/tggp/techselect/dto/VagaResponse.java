package com.br.tggp.techselect.dto;

import com.br.tggp.techselect.enums.NivelExp;
import com.br.tggp.techselect.enums.NivelSkill;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VagaResponse {

    private Long idVaga;
    private String tituloVaga;
    private NivelExp nivel;
    private Integer expMin;
    private String descricao;
    private Long idRecrutador;
    private SetorResponse setor;
    private List<SkillResponse> skills;

    private String urlLogo;

    public VagaResponse(Long idVaga, String tituloVaga, NivelExp nivel, Integer expMin, String descricao, Long idRecrutador, SetorResponse setor, List<SkillResponse> skills) {
        this.idVaga = idVaga;
        this.tituloVaga = tituloVaga;
        this.nivel = nivel;
        this.expMin = expMin;
        this.descricao = descricao;
        this.idRecrutador = idRecrutador;
        this.setor = setor;
        this.skills = skills;
    }

}
