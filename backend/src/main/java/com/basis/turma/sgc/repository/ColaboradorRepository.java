package com.basis.turma.sgc.repository;

import com.basis.turma.sgc.domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    Colaborador findByEmail(String email);

    Colaborador findByCpf(String cpf);

    List<Colaborador> findByIdIn(List<Integer> ids);
}
