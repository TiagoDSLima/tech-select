package com.example.techselect.mapper;

import com.example.techselect.dto.AvaliacaoDTO;
import com.example.techselect.entity.Avaliacao;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoMapper {
    public static AvaliacaoDTO toDTO(Avaliacao entity) {
        if (entity == null) return null;
        AvaliacaoDTO dto = new AvaliacaoDTO();
        dto.setIdAvaliacao(entity.getIdAvaliacao());
        dto.setCandidato(CandidatoMapper.toDTO(entity.getIdCandidato()));
        dto.setData(entity.getData());
        dto.setApto(entity.getApto());
        return dto;
    }

    public static Avaliacao toEntity(AvaliacaoDTO dto) {
        if (dto == null) return null;
        Avaliacao entity = new Avaliacao();
        entity.setIdAvaliacao(dto.getIdAvaliacao());
        entity.setIdCandidato(CandidatoMapper.toEntity(dto.getCandidato()));
        entity.setData(dto.getData());
        entity.setApto(dto.getApto());
        return entity;
    }

    public static List<AvaliacaoDTO> toDTO(List<Avaliacao> entities) {
        List<AvaliacaoDTO> dtos = new ArrayList<>();
        if (entities != null) {
            for (Avaliacao entity : entities) {
                dtos.add(toDTO(entity));
            }
        }
        return dtos;
    }

    public static List<Avaliacao> toEntity(List<AvaliacaoDTO> dtos) {
        List<Avaliacao> entities = new ArrayList<>();
        if (dtos != null) {
            for (AvaliacaoDTO dto : dtos) {
                entities.add(toEntity(dto));
            }
        }
        return entities;
    }
}
