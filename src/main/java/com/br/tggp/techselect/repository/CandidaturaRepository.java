package com.br.tggp.techselect.repository;

import com.br.tggp.techselect.model.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {

    List<Candidatura> findByVaga_Recrutador_IdRecrutador(Long idRecrutador);
}
