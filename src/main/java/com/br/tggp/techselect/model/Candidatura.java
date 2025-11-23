package com.br.tggp.techselect.model;

import com.br.tggp.techselect.enums.Apto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "candidatura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidatura")
    private Long idCandidatura;

    @NotBlank
    @Size(max = 150)
    @Column(name = "nome_completo", nullable = false, length = 150)
    private String nomeCompleto;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @NotBlank
    @Size(max = 11)
    @Column(name = "telefone", nullable = false, length = 11)
    private String telefone;

    @NotNull
    @Column(name = "exp", nullable = false)
    private Integer exp;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_vaga", nullable = false)
    private Vaga vaga;

    @OneToMany(mappedBy = "candidatura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills;

    @Transient
    private Apto aptidao;
}