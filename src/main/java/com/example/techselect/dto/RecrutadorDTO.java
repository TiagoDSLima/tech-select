package com.example.techselect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecrutadorDTO {

    private Long idRecrutador;
    private String nome;
    private String email;
    private String senha;
}
