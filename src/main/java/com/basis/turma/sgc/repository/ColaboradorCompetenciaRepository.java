package com.basis.turma.sgc.repository;

import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.domain.ColaboradorCompetenciaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ColaboradorCompetenciaRepository extends JpaRepository<ColaboradorCompetencia, ColaboradorCompetenciaPK> {

    @Query("select cc.competencia.id from ColaboradorCompetencia cc where cc.colaborador.id = :id")
    List<Integer> buscarPorColaborador(@Param("id") Integer id);

//    @Query("select tfcc.turmaformacao.id from TurmaFormacaoColaboradorCompetencia tfcc, TurmaFormacao tf where tf.datainicio = :datainicio")
//    List<Integer> buscarTurmaFormacaoPorDataInicio(@Param("datainicio") LocalDate datainicio);
}
