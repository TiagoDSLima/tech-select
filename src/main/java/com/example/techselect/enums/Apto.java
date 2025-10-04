package com.example.techselect.enums;

import lombok.Getter;

@Getter
public enum Apto {

    APTO("Apto"),
    MUITO_APTO("Muito Apto"),
    INAPTO("Inapto");

    private final String descricao;
    Apto(String descricao) {
        this.descricao = descricao;
    }

    public static Apto fromString(String valor) {
        for (Apto apto : Apto.values()) {
            if (apto.descricao.equalsIgnoreCase(valor)) {
                return apto;
            }
        }
        throw new IllegalArgumentException("Valor inválido para aptidão: " + valor);
    }
}
