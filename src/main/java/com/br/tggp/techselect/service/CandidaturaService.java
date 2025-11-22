package com.br.tggp.techselect.service;

import com.br.tggp.techselect.dto.CandidaturaRequest;
import com.br.tggp.techselect.dto.CandidaturaResponse;
import com.br.tggp.techselect.enums.Apto;
import com.br.tggp.techselect.mapper.CandidaturaMapper;
import com.br.tggp.techselect.model.Candidatura;
import com.br.tggp.techselect.repository.CandidaturaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidaturaService {

    private final CandidaturaRepository candidaturaRepository;
    private final MinioService minioService;
    private final RecrutadorService recrutadorService;
    private final AvaliadorDeCandidatura avaliadorDeCandidatura;


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
        List<Candidatura> candidaturas = retornaCandidaturasPorRecrutador(idRecrutador);
        verificacoesListagemCandidaturas(idRecrutador, candidaturas);
        for (Candidatura candidatura : candidaturas) {
            Apto apto = avaliadorDeCandidatura.avaliacaoCandidatura(candidatura);
            candidatura.setAptidao(apto);
        }
        return CandidaturaMapper.toResponseList(candidaturas);
    }

    public void verificacoesListagemCandidaturas(Long idRecrutador, List<Candidatura> candidaturas) {
        verificaExistenciaDoRecrutador(idRecrutador);
        verificaListaVazia(candidaturas);
    }

    public void verificaListaVazia(List<Candidatura> candidaturas){
        if (candidaturas == null || candidaturas.isEmpty()) {
            throw new EntityNotFoundException("Recrutador sem candidaturas!");
        }
    }

    public void verificaExistenciaDoRecrutador(Long idRecrutador) {
        if (idRecrutador == null || !recrutadorService.existeRecrutador(idRecrutador)) {
            throw new IllegalArgumentException("Recrutador inexistente");
        }
    }

    public List<Candidatura> retornaCandidaturasPorRecrutador(Long idRecrutador) {
        return candidaturaRepository.findAllWithVaga(idRecrutador);
    }
}
