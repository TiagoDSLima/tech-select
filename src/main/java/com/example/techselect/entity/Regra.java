package com.example.techselect.entity;

import com.example.techselect.enums.Senioridade;
import com.example.techselect.enums.Setor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Regra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegra;
    @Column(name = "SETOR", nullable = false)
    private Setor setor;
    @Column(name = "SENIORIDADE", nullable = false)
    private Senioridade senioridade;
    @Column(name = "EXPERIENCIA_MINIMA", nullable = false)
    private Integer experienciaMinima;
    @ManyToMany
    @JoinTable(
            name = "REGRA_SKILL",
            joinColumns = @JoinColumn(name = "ID_REGRA", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "ID_SKILL", nullable = false)
    )
    private List<Skill> skills;
}
