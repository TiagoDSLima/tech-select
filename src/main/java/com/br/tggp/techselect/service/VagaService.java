package com.br.tggp.techselect.service;

import com.br.tggp.techselect.dto.VagaRequest;
import com.br.tggp.techselect.dto.VagaResponse;
import com.br.tggp.techselect.mapper.SkillMapper;
import com.br.tggp.techselect.mapper.VagaMapper;
import com.br.tggp.techselect.model.Setor;
import com.br.tggp.techselect.model.Skill;
import com.br.tggp.techselect.model.Vaga;
import com.br.tggp.techselect.repository.VagaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VagaService {

    private final VagaRepository vagaRepository;
    private final RecrutadorService recrutadorService;

    public VagaResponse cadastrarVaga(VagaRequest vagaRequest) {
        if(vagaRequest.getIdRecrutador() == null || !recrutadorService.existeRecrutador(vagaRequest.getIdRecrutador())) {
            throw new IllegalArgumentException("Recrutador inexistente");
        }

        Vaga vaga = VagaMapper.toEntity(vagaRequest);

        if (vaga.getSkills() != null) {
            vaga.getSkills().forEach(skill -> skill.setVaga(vaga));
        }

        return VagaMapper.toResponse(vagaRepository.save(vaga));

    }

    public List<VagaResponse> listarVagas(Long idRecrutador) {
        if(idRecrutador == null || !recrutadorService.existeRecrutador(idRecrutador)) {
            throw new IllegalArgumentException("Recrutador inexistente");
        }

        List<Vaga> vagas = vagaRepository.findByRecrutador_IdRecrutador(idRecrutador);

        List<VagaResponse> vagasResponse = VagaMapper.toListResponse(vagas);

        return vagasResponse;
    }

    public VagaResponse atualizarVaga(VagaRequest vagaRequest, Long idVaga) {
        Vaga vagaExistente = vagaRepository.findById(idVaga)
                .orElseThrow(() -> new EntityNotFoundException("Vaga não encontrada"));

        vagaExistente.setTituloVaga(vagaRequest.getTituloVaga());
        vagaExistente.setNivel(vagaRequest.getNivel());
        vagaExistente.setExpMin(vagaRequest.getExpMin());
        vagaExistente.setDescricao(vagaRequest.getDescricao());
        Setor setor = new Setor();
        setor.setIdSetor(vagaRequest.getIdSetor());
        vagaExistente.setSetor(setor);

        if (vagaRequest.getSkills() != null) {
            vagaExistente.getSkills().clear();
            List<Skill> novasSkills = SkillMapper.toListEntity(vagaRequest.getSkills());
            vagaExistente.getSkills().addAll(novasSkills);
        }

        Vaga vagaAtualizada = vagaRepository.save(vagaExistente);
        return VagaMapper.toResponse(vagaAtualizada);
    }

    public void deletarVaga(Long idVaga) {
        if(!vagaRepository.existsById(idVaga)) {
            throw new IllegalArgumentException("Vaga inexistente");
        }
        vagaRepository.deleteById(idVaga);
    }

}
