package com.example.techselect.dto;

import com.example.techselect.entity.Skill;
import com.example.techselect.enums.Senioridade;
import com.example.techselect.enums.Setor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegraDTO {

    private Long idRegra;
    private Setor setor;
    private Senioridade senioridade;
    private Integer experienciaMinima;
    private List<SkillDTO> skills;
}
