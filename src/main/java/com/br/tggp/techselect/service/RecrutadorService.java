package com.br.tggp.techselect.service;

import com.br.tggp.techselect.dto.RecrutadorRequest;
import com.br.tggp.techselect.dto.RecrutadorResponse;
import com.br.tggp.techselect.exception.exceptions.EmailJaCadastradoException;
import com.br.tggp.techselect.exception.exceptions.UploadLogoException;
import com.br.tggp.techselect.mapper.RecrutadorMapper;
import com.br.tggp.techselect.model.Recrutador;
import com.br.tggp.techselect.repository.RecrutadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class RecrutadorService {

    private final RecrutadorRepository recrutadorRepository;
    private final MinioService minioService;

    public RecrutadorResponse criarRecrutador(RecrutadorRequest recrutadorRequest) {

        validarEmailJaExistente(recrutadorRequest.getEmail());

        Recrutador recrutador = criarEntidade(recrutadorRequest);
        recrutador = recrutadorRepository.save(recrutador);

        recrutador = salvarLogoSeExistir(recrutador, recrutadorRequest);

        return RecrutadorMapper.toResponse(recrutador);
    }

    public void validarEmailJaExistente(String email) {
        if (recrutadorRepository.findByEmail(email) != null) {
            throw new EmailJaCadastradoException();
        }
    }

    private Recrutador criarEntidade(RecrutadorRequest request) {
        String senhaEncriptada = new BCryptPasswordEncoder().encode(request.getSenha());
        request.setSenha(senhaEncriptada);
        return RecrutadorMapper.toEntity(request);
    }

    public UserDetails buscarPorEmail(String email){
        return recrutadorRepository.findByEmail(email);
    }

    public boolean existeRecrutador(Long id){
        return recrutadorRepository.existsById(id);
    }

    private Recrutador salvarLogoSeExistir(Recrutador recrutador, RecrutadorRequest request) {
        if (arquivoInexistente(request.getUrlLogo())) {
            return recrutador;
        }

        try {
            String nomeObjeto = gerarNomeObjeto(recrutador.getIdRecrutador(), request);
            String url = minioService.subirArquivo(
                    nomeObjeto,
                    request.getUrlLogo().getInputStream(),
                    request.getUrlLogo().getContentType()
            );

            recrutador.setUrlLogo(url);
            return recrutadorRepository.save(recrutador);

        } catch (Exception e) {
            recrutadorRepository.deleteById(recrutador.getIdRecrutador());
            throw new UploadLogoException();
        }
    }

    private boolean arquivoInexistente(MultipartFile arquivo){
        if(arquivo == null || arquivo.getOriginalFilename() == null || arquivo.getOriginalFilename().trim().isEmpty()) {
            return true;
        }

        return false;
    }

    private String gerarNomeObjeto(Long id, RecrutadorRequest request) {
        return "logos/" + id + "_" + request.getUrlLogo().getOriginalFilename();
    }
}
