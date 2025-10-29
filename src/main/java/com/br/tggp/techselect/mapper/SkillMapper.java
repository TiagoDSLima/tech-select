package com.br.tggp.techselect.mapper;

import com.br.tggp.techselect.dto.SkillRequest;
import com.br.tggp.techselect.dto.SkillResponse;
import com.br.tggp.techselect.model.Candidatura;
import com.br.tggp.techselect.model.Recrutador;
import com.br.tggp.techselect.model.Skill;
import com.br.tggp.techselect.model.Vaga;

public class SkillMapper {

    public static Skill toEntity(SkillRequest dto) {
        if (dto == null) return null;

        Skill s = new Skill();
        s.setDescricao(dto.getDescricao());
        s.setNivel(dto.getNivel());
        Recrutador r = new Recrutador();
        r.setIdRecrutador(dto.getIdRecrutador());
        s.setRecrutador(r);
        if(dto.getIdVaga() != null){
            Vaga v = new Vaga();
            v.setIdVaga(dto.getIdVaga());
            s.setVaga(v);
        }
        if(dto.getIdCandidatura() != null){
            Candidatura c = new Candidatura();
            c.setIdCandidatura(dto.getIdCandidatura());
            s.setCandidatura(c);
        }
        return s;
    }

    public static SkillResponse toResponse(Skill entity) {
        if (entity == null) return null;

        return new SkillResponse(
                entity.getIdSkill(),
                entity.getDescricao(),
                entity.getNivel(),
                entity.getRecrutador().getIdRecrutador(),
                entity.getVaga() != null ? entity.getVaga().getIdVaga() : null,
                entity.getCandidatura() != null ? entity.getCandidatura().getIdCandidatura() : null
        );
    }
}