package com.br.tggp.techselect.mapper;

import com.br.tggp.techselect.dto.RecrutadorRequest;
import com.br.tggp.techselect.dto.RecrutadorResponse;
import com.br.tggp.techselect.model.Recrutador;

public class RecrutadorMapper {

    public static Recrutador toEntity(RecrutadorRequest dto) {
        if (dto == null) return null;

        Recrutador r = new Recrutador();
        r.setEmail(dto.getEmail());
        r.setSenha(dto.getSenha());
        r.setNomeEmpresa(dto.getNomeEmpresa());
        r.setNomeCompleto(dto.getNomeCompleto());
        return r;
    }

    public static RecrutadorResponse toResponse(Recrutador entity) {
        if (entity == null) return null;

        return new RecrutadorResponse(
                entity.getIdRecrutador(),
                entity.getEmail(),
                entity.getNomeEmpresa(),
                entity.getUrlLogo(),
                entity.getNomeCompleto()
        );
    }
}
