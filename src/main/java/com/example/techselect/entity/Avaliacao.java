package com.example.techselect.entity;

import com.example.techselect.enums.Apto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idAvaliacao;
    @ManyToOne
    @JoinColumn(name = "ID_CANDIDATO", nullable = false)
    private Candidato idCandidato;
    @Column(name = "DATA", nullable = false)
    private LocalDateTime data;
    @Column(name = "APTO", nullable = false)
    private Apto apto;
}
