package com.basis.turma.sgc.repository;


import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaFormacaoCompetenciaColaboradorRepository extends JpaRepository<TurmaFormacaoCompetenciaColaborador, Integer> {
}
