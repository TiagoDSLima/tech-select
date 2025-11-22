package com.br.tggp.techselect.model;

import com.br.tggp.techselect.enums.NivelExp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vaga")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaga")
    private Long idVaga;

    @NotNull
    @Size(max = 100)
    @Column(name = "titulo_vaga", nullable = false, length = 100)
    private String tituloVaga;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "nivel", nullable = false, columnDefinition = "nivel_exp")
    private NivelExp nivel;

    @NotNull
    @Column(name = "exp_min", nullable = false)
    private Integer expMin;

    @NotBlank
    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_recrutador", nullable = false)
    private Recrutador recrutador;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_setor", nullable = false)
    private Setor setor;

    @OneToMany(mappedBy = "vaga")
    private List<Candidatura> candidaturas;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills;
}
