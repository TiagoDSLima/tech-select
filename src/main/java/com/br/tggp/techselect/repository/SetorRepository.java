package com.br.tggp.techselect.repository;

import com.br.tggp.techselect.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetorRepository extends JpaRepository<Setor, Long> {

    List<Setor> findAllByRecrutador_IdRecrutador(Long idRecrutador);
}
