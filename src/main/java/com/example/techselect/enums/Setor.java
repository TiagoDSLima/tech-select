package com.example.techselect.enums;

import lombok.Getter;

@Getter
public enum Setor {

    DESENVOLVIMENTO("Desenvolvimento"),
    SUPORTE("Suporte"),
    COMERCIAL("Comercial");

    private final String descricao;

    Setor(String descricao) {
        this.descricao = descricao;
    }

    public static Setor fromString(String valor) {
        for (Setor s : Setor.values()) {
            if (s.descricao.equalsIgnoreCase(valor)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Valor inválido para setor: " + valor);
    }

}
