package com.basis.turma.sgc.repository;


import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaboradorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaFormacaoCompetenciaColaboradorRepository extends JpaRepository<TurmaFormacaoCompetenciaColaborador, TurmaFormacaoCompetenciaColaboradorPK> {
    List<TurmaFormacaoCompetenciaColaborador> findByTurmaFormacaoId(Integer turmaFormacaoId);
}
