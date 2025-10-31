package com.br.tggp.techselect.repository;

import com.br.tggp.techselect.model.Recrutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RecrutadorRepository extends JpaRepository<Recrutador, Long> {

    UserDetails findByEmail(String email);
}
