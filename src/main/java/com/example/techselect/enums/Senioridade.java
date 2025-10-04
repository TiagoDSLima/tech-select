package com.example.techselect.enums;

import lombok.Getter;

@Getter
public enum Senioridade {
    JUNIOR("Júnior"),
    PLENO("Pleno"),
    SENIOR("Senior");

    private final String descricao;

    Senioridade(String descricao) {
        this.descricao = descricao;
    }

    public static Senioridade fromString(String valor) {
        for (Senioridade s : Senioridade.values()) {
            if (s.descricao.equalsIgnoreCase(valor)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Senioridade: " + valor);
    }
}
