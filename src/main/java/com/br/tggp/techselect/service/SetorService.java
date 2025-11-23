package com.br.tggp.techselect.service;

import com.br.tggp.techselect.dto.SetorRequest;
import com.br.tggp.techselect.dto.SetorResponse;
import com.br.tggp.techselect.mapper.SetorMapper;
import com.br.tggp.techselect.model.Setor;
import com.br.tggp.techselect.repository.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SetorService {

    private final SetorRepository setorRepository;
    private final RecrutadorService recrutadorService;

    public SetorResponse criarSetor(SetorRequest setorRequest){
        if(setorRequest.getIdRecrutador() == null || !recrutadorService.existeRecrutador(setorRequest.getIdRecrutador())) {
            throw new IllegalArgumentException("Recrutador inexistente");
        }
        Setor setor = SetorMapper.toEntity(setorRequest);
        return SetorMapper.toResponse(setorRepository.save(setor));
    }

    public void excluirSetor(Long id){
        if(!setorRepository.existsById(id)) {
            throw new IllegalArgumentException("Setor inexistente!");
        }
        setorRepository.deleteById(id);
    }

    public List<SetorResponse> listarSetores(Long idRecrutador){
        if(idRecrutador == null || !recrutadorService.existeRecrutador(idRecrutador)) {
            throw new IllegalArgumentException("Recrutador inexistente");
        }

        return SetorMapper.toListResponse(setorRepository.findAllByRecrutador_IdRecrutador(idRecrutador));
    }
}
