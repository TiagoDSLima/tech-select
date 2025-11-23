package com.br.tggp.techselect.dto;


import jakarta.validation.constraints.Email;
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
public class CandidaturaRequest {

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(max = 150)
    private String nomeCompleto;

    @NotBlank
    @Size(max = 11)
    private String telefone;

    @NotNull
    private Integer exp;

    @NotNull
    private Long idVaga;

    @NotNull
    private List<SkillRequest> skills;
}