package com.br.tggp.techselect.repository;

import com.br.tggp.techselect.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

    @Query("SELECT v FROM Vaga v " +
            "LEFT JOIN FETCH v.skills " +
            "LEFT JOIN FETCH v.recrutador " +
            "LEFT JOIN FETCH v.setor " +
            "WHERE v.recrutador.idRecrutador = :idRecrutador")
    List<Vaga> findAllComRelacionamentosPorRecrutador(@Param("idRecrutador") Long idRecrutador);
}
