package com.basis.turma.sgc.repository;

import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.domain.ColaboradorCompetenciaPK;
import com.basis.turma.sgc.service.dto.SelecionaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ColaboradorCompetenciaRepository extends JpaRepository<ColaboradorCompetencia, ColaboradorCompetenciaPK> {

    ColaboradorCompetencia  findByColaboradorIdAndCompetenciaId(Integer colaboradorId, Integer competenciaId);

    List<ColaboradorCompetencia> findByCompetenciaIdAndSenioridade(Integer competenciaId, Integer senioridade);
}
