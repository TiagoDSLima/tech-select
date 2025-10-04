package com.example.techselect.mapper;

import com.example.techselect.dto.RecrutadorDTO;
import com.example.techselect.entity.Recrutador;

import java.util.ArrayList;
import java.util.List;

public class RecrutadorMapper {

    public static RecrutadorDTO toDTO(Recrutador entity) {
        if (entity == null) return null;
        RecrutadorDTO dto = new RecrutadorDTO();
        dto.setIdRecrutador(entity.getIdRecrutador());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public static Recrutador toEntity(RecrutadorDTO dto) {
        if (dto == null) return null;
        Recrutador entity = new Recrutador();
        entity.setIdRecrutador(dto.getIdRecrutador());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        if(dto.getSenha() != null && !dto.getSenha().isEmpty()){
            entity.setSenha(dto.getSenha());
        }
        return entity;
    }

    public static List<RecrutadorDTO> toDTO(List<Recrutador> entities) {
        List<RecrutadorDTO> dtos = new ArrayList<>();
        if (entities != null) {
            for (Recrutador entity : entities) {
                dtos.add(toDTO(entity));
            }
        }
        return dtos;
    }

    public static List<Recrutador> toEntity(List<RecrutadorDTO> dtos) {
        List<Recrutador> entities = new ArrayList<>();
        if (dtos != null) {
            for (RecrutadorDTO dto : dtos) {
                entities.add(toEntity(dto));
            }
        }
        return entities;
    }
}
