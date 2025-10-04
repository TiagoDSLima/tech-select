package com.example.techselect.mapper;

import com.example.techselect.dto.RegraDTO;
import com.example.techselect.entity.Regra;

import java.util.ArrayList;
import java.util.List;

public class RegraMapper {
    public static RegraDTO toDTO(Regra entity) {
        if (entity == null) return null;
        RegraDTO dto = new RegraDTO();
        dto.setIdRegra(entity.getIdRegra());
        dto.setSetor(entity.getSetor());
        dto.setSenioridade(entity.getSenioridade());
        dto.setExperienciaMinima(entity.getExperienciaMinima());
        dto.setSkills(SkillMapper.toDTO(entity.getSkills()));
        return dto;
    }

    public static Regra toEntity(RegraDTO dto) {
        if (dto == null) return null;
        Regra entity = new Regra();
        entity.setIdRegra(dto.getIdRegra());
        entity.setSetor(dto.getSetor());
        entity.setSenioridade(dto.getSenioridade());
        entity.setExperienciaMinima(dto.getExperienciaMinima());
        entity.setSkills(SkillMapper.toEntity(dto.getSkills()));
        return entity;
    }

    public static List<RegraDTO> toDTO(List<Regra> entities) {
        List<RegraDTO> dtos = new ArrayList<>();
        if (entities != null) {
            for (Regra entity : entities) {
                dtos.add(toDTO(entity));
            }
        }
        return dtos;
    }

    public static List<Regra> toEntity(List<RegraDTO> dtos) {
        List<Regra> entities = new ArrayList<>();
        if (dtos != null) {
            for (RegraDTO dto : dtos) {
                entities.add(toEntity(dto));
            }
        }
        return entities;
    }
}
