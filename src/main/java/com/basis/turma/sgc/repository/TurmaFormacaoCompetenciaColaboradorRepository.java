package com.basis.turma.sgc.repository;

import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorCompetenciaRepository extends JpaRepository<ColaboradorCompetencia, Integer> {
}
