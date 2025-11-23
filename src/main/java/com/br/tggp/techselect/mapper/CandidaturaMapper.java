package com.br.tggp.techselect.mapper;

import com.br.tggp.techselect.dto.CandidaturaRequest;
import com.br.tggp.techselect.dto.CandidaturaResponse;
import com.br.tggp.techselect.dto.SkillResponse;
import com.br.tggp.techselect.model.Candidatura;
import com.br.tggp.techselect.model.Skill;
import com.br.tggp.techselect.model.Vaga;
import java.util.List;

public class CandidaturaMapper {

    public static Candidatura toEntity(CandidaturaRequest dto) {
        if (dto == null) return null;

        Candidatura c = new Candidatura();
        c.setNomeCompleto(dto.getNomeCompleto());
        c.setEmail(dto.getEmail());
        c.setTelefone(dto.getTelefone());
        c.setExp(dto.getExp());
        Vaga v = new Vaga();
        v.setIdVaga(dto.getIdVaga());
        c.setVaga(v);
        if (dto.getSkills() != null) {
            List<Skill> skills = SkillMapper.toListEntity(dto.getSkills());
            c.setSkills(skills);
        }
        return c;
    }

    public static CandidaturaResponse toResponse(Candidatura entity) {
        if (entity == null) return null;

        List<SkillResponse> skills = null;
        if (entity.getSkills() != null) {
            skills = SkillMapper.toListResponse(entity.getSkills());
        }


        return new CandidaturaResponse(
                entity.getIdCandidatura(),
                entity.getNomeCompleto(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getExp(),
                entity.getVaga().getIdVaga(),
                skills,
                entity.getAptidao()
        );
    }

    public static List<CandidaturaResponse> toResponseList(List<Candidatura> entities) {
        return entities.stream()
                .map(CandidaturaMapper::toResponse)
                .toList();
    }
}
