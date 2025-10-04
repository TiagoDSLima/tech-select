package com.example.techselect.mapper;

import com.example.techselect.dto.CandidatoDTO;
import com.example.techselect.entity.Candidato;

import java.util.ArrayList;
import java.util.List;

public class CandidatoMapper {
    public static CandidatoDTO toDTO(Candidato entity) {
        if (entity == null) return null;
        CandidatoDTO dto = new CandidatoDTO();
        dto.setIdCandidato(entity.getIdCandidato());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setTelefone(entity.getTelefone());
        dto.setAnosXp(entity.getAnosXp());
        dto.setSenioridadeAtual(entity.getSenioridadeAtual());
        dto.setSkills(SkillMapper.toDTO(entity.getSkills()));
        return dto;
    }

    public static Candidato toEntity(CandidatoDTO dto) {
        if (dto == null) return null;
        Candidato entity = new Candidato();
        entity.setIdCandidato(dto.getIdCandidato());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setAnosXp(dto.getAnosXp());
        entity.setSenioridadeAtual(dto.getSenioridadeAtual());
        entity.setSkills(SkillMapper.toEntity(dto.getSkills()));
        return entity;
    }

    public static List<CandidatoDTO> toDTO(List<Candidato> entities) {
        List<CandidatoDTO> dtos = new ArrayList<>();
        if (entities != null) {
            for (Candidato entity : entities) {
                dtos.add(toDTO(entity));
            }
        }
        return dtos;
    }

    public static List<Candidato> toEntity(List<CandidatoDTO> dtos) {
        List<Candidato> entities = new ArrayList<>();
        if (dtos != null) {
            for (CandidatoDTO dto : dtos) {
                entities.add(toEntity(dto));
            }
        }
        return entities;
    }
}
