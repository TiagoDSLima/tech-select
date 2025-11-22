package com.br.tggp.techselect.repository;

import com.br.tggp.techselect.model.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {

    @Query("""
    SELECT c 
    FROM Candidatura c 
    JOIN FETCH c.vaga v 
    WHERE v.recrutador.idRecrutador = :idRecrutador
    """)
    List<Candidatura> findAllWithVaga(Long idRecrutador);

}
