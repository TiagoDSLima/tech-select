package com.br.tggp.techselect.repository;

import com.br.tggp.techselect.model.Candidatura;
import com.br.tggp.techselect.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

    List<Vaga> findByRecrutador_IdRecrutador(Long idRecrutador);
}
