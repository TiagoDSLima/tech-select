package com.br.tggp.techselect.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Apto {
    APTO("Apto"),
    INAPTO("Inapto"),
    MUITO_APTO("Muito apto");

    private final String descricao;

    Apto(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }
}
