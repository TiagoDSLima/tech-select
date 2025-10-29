package com.br.tggp.techselect.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetorRequest {

    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotNull
    private Long idRecrutador;
}
