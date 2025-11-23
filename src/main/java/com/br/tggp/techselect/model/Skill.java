package com.br.tggp.techselect.model;

import com.br.tggp.techselect.enums.NivelSkill;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_skill")
    private Long idSkill;

    @NotBlank
    @Size(max = 50)
    @Column(name = "descricao", length = 50)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel", nullable = false)
    private NivelSkill nivel = NivelSkill.CANDIDATURA;

    @ManyToOne
    @JoinColumn(name = "id_vaga")
    private Vaga vaga;

    @ManyToOne
    @JoinColumn(name = "id_candidatura")
    private Candidatura candidatura;
}