package com.br.tggp.techselect.service;

import com.br.tggp.techselect.dto.RecrutadorRequest;
import com.br.tggp.techselect.dto.RecrutadorResponse;
import com.br.tggp.techselect.mapper.RecrutadorMapper;
import com.br.tggp.techselect.model.Recrutador;
import com.br.tggp.techselect.repository.RecrutadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecrutadorService {

    private final RecrutadorRepository recrutadorRepository;
    private final MinioService minioService;

    public RecrutadorResponse criarRecrutador(RecrutadorRequest recrutadorRequest) {

        try {
            if (recrutadorRepository.findByEmail(recrutadorRequest.getEmail()) != null)
                throw new IllegalArgumentException("Email já cadastrado!");

            String senhaEncriptada = new BCryptPasswordEncoder().encode(recrutadorRequest.getSenha());
            recrutadorRequest.setSenha(senhaEncriptada);

            Recrutador recrutador = RecrutadorMapper.toEntity(recrutadorRequest);
            recrutador = recrutadorRepository.save(recrutador);

            String nomeObjeto = "logos/" + recrutador.getIdRecrutador() + "_" + recrutadorRequest.getUrlLogo().getOriginalFilename();
            String urlImagem = minioService.subirArquivo(nomeObjeto, recrutadorRequest.getUrlLogo().getInputStream(), recrutadorRequest.getUrlLogo().getContentType());
            recrutador.setUrlLogo(urlImagem);
            return RecrutadorMapper.toResponse(recrutadorRepository.save(recrutador));
        } catch(Exception e){
            throw new RuntimeException("Erro ao criar recrutador: ", e);
        }
    }

    public UserDetails buscarPorEmail(String email){
        return recrutadorRepository.findByEmail(email);
    }

    public boolean existeRecrutador(Long id){
        return recrutadorRepository.existsById(id);
    }
}
