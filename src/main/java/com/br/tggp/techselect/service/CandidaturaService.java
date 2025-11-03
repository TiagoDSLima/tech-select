package com.br.tggp.techselect.service;

import com.br.tggp.techselect.dto.CandidaturaRequest;
import com.br.tggp.techselect.dto.CandidaturaResponse;
import com.br.tggp.techselect.mapper.CandidaturaMapper;
import com.br.tggp.techselect.model.Candidatura;
import com.br.tggp.techselect.repository.CandidaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidaturaService {

    private final CandidaturaRepository candidaturaRepository;
    private final MinioService minioService;
    private final RecrutadorService recrutadorService;

    public CandidaturaResponse criarCandidatura(CandidaturaRequest candidaturaRequest) throws Exception {
            Candidatura candidatura = CandidaturaMapper.toEntity(candidaturaRequest);
            candidatura = candidaturaRepository.save(candidatura);

            String nomeObjeto = "logos/" + candidatura.getIdCandidatura() + "_" + candidaturaRequest.getUrlCurriculo().getOriginalFilename();
            String urlImagem = minioService.subirArquivo(nomeObjeto, candidaturaRequest.getUrlCurriculo().getInputStream(), candidaturaRequest.getUrlCurriculo().getContentType());
            candidatura.setUrlCurriculo(urlImagem);
            return CandidaturaMapper.toResponse(candidaturaRepository.save(candidatura));
    }

    public List<CandidaturaResponse> listarCandidaturas(Long idRecrutador){
        if(idRecrutador == null || !recrutadorService.existeRecrutador(idRecrutador)) {
            throw new IllegalArgumentException("Recrutador inexistente");
        }
        List<Candidatura> candidaturas = candidaturaRepository.findByVaga_Recrutador_IdRecrutador(idRecrutador);
        return candidaturas.stream()
                .map(CandidaturaMapper::toResponse)
                .toList();
    }
}
