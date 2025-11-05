package com.br.tggp.techselect.service;

import com.br.tggp.techselect.dto.CandidaturaRequest;
import com.br.tggp.techselect.dto.CandidaturaResponse;
import com.br.tggp.techselect.dto.SkillResponse;
import com.br.tggp.techselect.dto.VagaResponse;
import com.br.tggp.techselect.enums.Apto;
import com.br.tggp.techselect.enums.NivelSkill;
import com.br.tggp.techselect.mapper.CandidaturaMapper;
import com.br.tggp.techselect.model.Candidatura;
import com.br.tggp.techselect.repository.CandidaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidaturaService {

    private final CandidaturaRepository candidaturaRepository;
    private final MinioService minioService;
    private final RecrutadorService recrutadorService;
    private final VagaService vagaService;

    public CandidaturaResponse criarCandidatura(CandidaturaRequest candidaturaRequest){
        try {
            Candidatura candidatura = CandidaturaMapper.toEntity(candidaturaRequest);
            candidatura = candidaturaRepository.save(candidatura);

            String nomeObjeto = "curriculos/" + candidatura.getIdCandidatura() + "_" + candidaturaRequest.getUrlCurriculo().getOriginalFilename();
            String urlImagem = minioService.subirArquivo(nomeObjeto, candidaturaRequest.getUrlCurriculo().getInputStream(), candidaturaRequest.getUrlCurriculo().getContentType());
            candidatura.setUrlCurriculo(urlImagem);
            return CandidaturaMapper.toResponse(candidaturaRepository.save(candidatura));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar candidatura: ", e);
        }
    }

    public List<CandidaturaResponse> listarCandidaturas(Long idRecrutador) {
        if (idRecrutador == null || !recrutadorService.existeRecrutador(idRecrutador)) {
            throw new IllegalArgumentException("Recrutador inexistente");
        }
        List<Candidatura> candidaturas = candidaturaRepository.findByVaga_Recrutador_IdRecrutador(idRecrutador);

        if (candidaturas == null || candidaturas.isEmpty()) {
            return new ArrayList<>();
        }

        List<CandidaturaResponse> candidaturasResponse = candidaturas.stream()
                .map(CandidaturaMapper::toResponse)
                .toList();

        for (CandidaturaResponse candidaturaResponse : candidaturasResponse) {

            List<String> skillsCandidatura = candidaturaResponse.getSkills().stream()
                    .map(SkillResponse::getDescricao)
                    .toList();

            VagaResponse vagaResponse = vagaService.buscarVaga(candidaturaResponse.getIdVaga());

            List<String> skillsObrigatorias = vagaResponse.getSkills().stream()
                    .filter(skill -> NivelSkill.OBRIGATORIA.equals(skill.getNivel()))
                    .map(SkillResponse::getDescricao)
                    .toList();

            List<String> skillsDesejaveis = vagaResponse.getSkills().stream()
                    .filter(skill -> NivelSkill.DESEJAVEL.equals(skill.getNivel()))
                    .map(SkillResponse::getDescricao)
                    .toList();

            boolean possuiObrigatorias = skillsCandidatura.containsAll(skillsObrigatorias);

            if (!possuiObrigatorias) {
                candidaturaResponse.setApto(Apto.INAPTO);
            } else if (candidaturaResponse.getExp() < vagaResponse.getExpMin()) {
                candidaturaResponse.setApto(Apto.INAPTO);
            } else {
                long qtdSkillDesejaveisCandidato = skillsDesejaveis.stream()
                        .filter(skillsCandidatura::contains)
                        .count();

                boolean vagaComUmaSkillDesejavel = skillsDesejaveis.size() == 1;
                boolean temPeloMenosDuasSkillDesejaveis = qtdSkillDesejaveisCandidato >= 2;
                boolean candidatoTemUmaSkillDesejavel = qtdSkillDesejaveisCandidato == 1;

                if (vagaComUmaSkillDesejavel && candidatoTemUmaSkillDesejavel) {
                    candidaturaResponse.setApto(Apto.MUITO_APTO);
                } else if (!vagaComUmaSkillDesejavel && temPeloMenosDuasSkillDesejaveis) {
                    candidaturaResponse.setApto(Apto.MUITO_APTO);
                } else {
                    candidaturaResponse.setApto(Apto.APTO);
                }
            }
        }
        return candidaturasResponse;
    }
}
