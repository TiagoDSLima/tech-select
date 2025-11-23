package com.br.tggp.techselect.mapper;

import com.br.tggp.techselect.dto.SetorRequest;
import com.br.tggp.techselect.dto.SetorResponse;
import com.br.tggp.techselect.model.Recrutador;
import com.br.tggp.techselect.model.Setor;
import java.util.List;

public class SetorMapper {

    public static Setor toEntity(SetorRequest dto) {
        if (dto == null) return null;

        Setor s = new Setor();
        s.setNome(dto.getNome());
        Recrutador r = new Recrutador();
        r.setIdRecrutador(dto.getIdRecrutador());
        s.setRecrutador(r);
        return s;
    }

    public static SetorResponse toResponse(Setor entity) {
        if (entity == null) return null;

        return new SetorResponse(
                entity.getIdSetor(),
                entity.getNome(),
                entity.getRecrutador() != null ? entity.getRecrutador().getIdRecrutador() : null
        );
    }

    public static List<SetorResponse> toListResponse(List<Setor> entities) {
        if (entities == null) return null;

        return entities.stream()
                .map(SetorMapper::toResponse)
                .toList();
    }
}
