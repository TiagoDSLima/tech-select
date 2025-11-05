package com.br.tggp.techselect.dto;

import com.br.tggp.techselect.enums.NivelSkill;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillRequest {

    @NotBlank
    @Size(max = 50)
    private String descricao;
    @NotNull
    private NivelSkill nivel;
    private Long idVaga;
    private Long idCandidatura;
}
