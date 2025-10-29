package com.br.tggp.techselect.mapper;

import com.br.tggp.techselect.dto.SkillResponse;
import com.br.tggp.techselect.dto.VagaRequest;
import com.br.tggp.techselect.dto.VagaResponse;
import com.br.tggp.techselect.model.Recrutador;
import com.br.tggp.techselect.model.Skill;
import com.br.tggp.techselect.model.Vaga;

import java.util.List;
import java.util.stream.Collectors;

public class VagaMapper {

    public static Vaga toEntity(VagaRequest dto) {
        if (dto == null) return null;

        Vaga v = new Vaga();
        v.setNivel(dto.getNivel());
        v.setExpMin(dto.getExpMin());
        v.setDescricao(dto.getDescricao());
        if (dto.getSkills() != null) {
            List<Skill> skills = dto.getSkills().stream()
                    .map(skillDto -> {
                        Skill skill = new Skill();
                        skill.setDescricao(skillDto.getDescricao());
                        skill.setNivel(skillDto.getNivel());
                        skill.setVaga(v);
                        return skill;
                    })
                    .collect(Collectors.toList());
            v.setSkills(skills);
        }
        Recrutador r = new Recrutador();
        r.setIdRecrutador(dto.getIdRecrutador());
        v.setRecrutador(r);
        return v;
    }

    public static VagaResponse toResponse(Vaga entity) {
        if (entity == null) return null;

        List<SkillResponse> skills = null;
        if (entity.getSkills() != null) {
            skills = entity.getSkills().stream()
                    .map(skill -> new SkillResponse(
                            skill.getIdSkill(),
                            skill.getDescricao(),
                            skill.getNivel(),
                            skill.getRecrutador().getIdRecrutador(),
                            skill.getVaga() != null ? skill.getVaga().getIdVaga() : null,
                            null
                    ))
                    .collect(Collectors.toList());
        }

        return new VagaResponse(
                entity.getIdVaga(),
                entity.getNivel(),
                entity.getExpMin(),
                entity.getDescricao(),
                entity.getRecrutador().getIdRecrutador(),
                skills
        );
    }
}
