package com.br.tggp.techselect.mapper;

import com.br.tggp.techselect.dto.SetorResponse;
import com.br.tggp.techselect.dto.SkillResponse;
import com.br.tggp.techselect.dto.VagaRequest;
import com.br.tggp.techselect.dto.VagaResponse;
import com.br.tggp.techselect.model.Recrutador;
import com.br.tggp.techselect.model.Setor;
import com.br.tggp.techselect.model.Skill;
import com.br.tggp.techselect.model.Vaga;

import java.util.List;

public class VagaMapper {

    public static Vaga toEntity(VagaRequest dto) {
        if (dto == null) return null;

        Vaga v = new Vaga();
        v.setTituloVaga(dto.getTituloVaga());
        v.setNivel(dto.getNivel());
        v.setExpMin(dto.getExpMin());
        v.setDescricao(dto.getDescricao());
        if (dto.getSkills() != null) {
            List<Skill> skills = SkillMapper.toListEntity(dto.getSkills());
            v.setSkills(skills);
        }
        Setor s = new Setor();
        s.setIdSetor(dto.getIdSetor());
        v.setSetor(s);
        Recrutador r = new Recrutador();
        r.setIdRecrutador(dto.getIdRecrutador());
        v.setRecrutador(r);
        return v;
    }

    public static VagaResponse toResponse(Vaga entity) {
        if (entity == null) return null;

        List<SkillResponse> skills = null;
        if (entity.getSkills() != null) skills = SkillMapper.toListResponse(entity.getSkills());

        SetorResponse setorResponse = SetorMapper.toResponse(entity.getSetor());

        VagaResponse vagaResponse = new VagaResponse(
                entity.getIdVaga(),
                entity.getTituloVaga(),
                entity.getNivel(),
                entity.getExpMin(),
                entity.getDescricao(),
                entity.getRecrutador().getIdRecrutador(),
                setorResponse,
                skills
        );

        if(entity.getRecrutador() != null && entity.getRecrutador().getIdRecrutador() != null
            && entity.getRecrutador().getUrlLogo() != null){
            vagaResponse.setUrlLogo(entity.getRecrutador().getUrlLogo());
        }

        return vagaResponse;
    }

    public static List<VagaResponse> toListResponse(List<Vaga> entities) {
        return entities.stream()
                .map(VagaMapper::toResponse)
                .toList();
    }
}
