package com.example.techselect.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recrutador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idRecrutador;
    @Column(name = "NOME", nullable = false)
    private String nome;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "SENHA", nullable = false)
    private String senha;

}
