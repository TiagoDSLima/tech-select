package com.example.techselect.dto;

import com.example.techselect.enums.Senioridade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidatoDTO {

    private Long idCandidato;
    private String nome;
    private String email;
    private String telefone;
    private Integer anosXp;
    private Senioridade senioridadeAtual;
    private List<SkillDTO> skills;
}
