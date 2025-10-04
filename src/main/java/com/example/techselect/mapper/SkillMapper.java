package com.example.techselect.mapper;

import com.example.techselect.dto.SkillDTO;
import com.example.techselect.entity.Skill;

import java.util.ArrayList;
import java.util.List;


public class SkillMapper {

    public static SkillDTO toDTO(Skill entity) {
        if (entity == null) return null;
        SkillDTO dto = new SkillDTO();
        dto.setIdSkill(entity.getIdSkill());
        dto.setNome(entity.getNome());
        return dto;
    }

    public static Skill toEntity(SkillDTO dto) {
        if (dto == null) return null;
        Skill entity = new Skill();
        entity.setIdSkill(dto.getIdSkill());
        entity.setNome(dto.getNome());
        return entity;
    }

    public static List<SkillDTO> toDTO(List<Skill> entitys) {
        List<SkillDTO> dtos = new ArrayList<>();
        for(Skill entity : entitys){
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

    public static List<Skill> toEntity(List<SkillDTO> dtos) {
        List<Skill> entitys = new ArrayList<>();
        for(SkillDTO dto : dtos){
            entitys.add(toEntity(dto));
        }
        return entitys;
    }
}
