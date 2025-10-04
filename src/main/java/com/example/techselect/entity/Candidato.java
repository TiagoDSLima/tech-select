package com.example.techselect.entity;

import com.example.techselect.enums.Senioridade;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "CANDIDATO")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidato;
    @Column(name = "NOME", nullable = false)
    private String nome;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "TELEFONE", nullable = false)
    private String telefone;
    @Column(name = "ANOS_XP", nullable = false)
    private Integer anosXp;
    @Column(name = "SENIORIDADE_ATUAL", nullable = false)
    private Senioridade senioridadeAtual;
    @ManyToMany
    @JoinTable(
            name = "CANDIDATO_SKILL",
            joinColumns = @JoinColumn(name = "ID_CANDIDATO"),
            inverseJoinColumns = @JoinColumn(name = "ID_SKILL")
    )
    private List<Skill> skills;

}
