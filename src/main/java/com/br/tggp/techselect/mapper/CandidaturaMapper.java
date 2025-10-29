package com.br.tggp.techselect.mapper;

import com.br.tggp.techselect.dto.CandidaturaRequest;
import com.br.tggp.techselect.dto.CandidaturaResponse;
import com.br.tggp.techselect.dto.SkillResponse;
import com.br.tggp.techselect.model.Candidatura;
import com.br.tggp.techselect.model.Skill;
import com.br.tggp.techselect.model.Vaga;

import java.util.List;
import java.util.stream.Collectors;

public class CandidaturaMapper {

    public static Candidatura toEntity(CandidaturaRequest dto) {
        if (dto == null) return null;

        Candidatura c = new Candidatura();
        c.setEmail(dto.getEmail());
        c.setTelefone(dto.getTelefone());
        c.setExp(dto.getExp());
        Vaga v = new Vaga();
        v.setIdVaga(dto.getIdVaga());
        c.setVaga(v);
        if (dto.getSkills() != null) {
            List<Skill> skills = dto.getSkills().stream()
                    .map(skillDto -> {
                        Skill skill = new Skill();
                        skill.setDescricao(skillDto.getDescricao());
                        skill.setNivel(skillDto.getNivel());
                        skill.setCandidatura(c);
                        return skill;
                    })
                    .collect(Collectors.toList());
            c.setSkills(skills);
        }
        return c;
    }

    public static CandidaturaResponse toResponse(Candidatura entity) {
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
                            skill.getCandidatura() != null ? skill.getCandidatura().getIdCandidatura() : null
                    ))
                    .collect(Collectors.toList());
        }


        return new CandidaturaResponse(
                entity.getIdCandidatura(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getExp(),
                entity.getUrlCurriculo(),
                entity.getVaga().getIdVaga(),
                skills
        );
    }
}
