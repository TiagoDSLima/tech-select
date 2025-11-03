package com.br.tggp.techselect.dto;

import com.br.tggp.techselect.enums.NivelExp;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VagaRequest {

    @NotNull
    @Size(max = 100)
    private String tituloVaga;

    @NotNull
    private NivelExp nivel;

    @NotNull
    private Integer expMin;

    @NotBlank
    @Size(max = 1000)
    private String descricao;

    @NotNull
    private Long idRecrutador;

    @NotNull
    private Long idSetor;

    @NotNull
    private List<SkillRequest> skills;

}