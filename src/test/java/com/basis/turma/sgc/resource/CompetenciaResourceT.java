package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.SgcApplication;
import com.basis.turma.sgc.builder.CompetenciaBuilder;
import com.basis.turma.sgc.service.mapper.competencia.CompetenciaMapper;
import com.basis.turma.sgc.util.TestUtil;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SgcApplication.class)
@Transactional
public class CompetenciaResourceT {

    private static final String URL = "/api/competencia";

    private MockMvc mockMvc;

    @Autowired
    private CompetenciaMapper competenciaMapper;

    @Autowired
    private CompetenciaBuilder competenciaBuilder;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void inicializaTeste(){
        competenciaBuilder.setCustomizacao(null);
    }

    @Test
    public void listarTest() throws Exception{
        competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        getMockMvc().perform(get(URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));

    }

    private MockMvc getMockMvc() {
        return null;
    }

    @Test
    public void inserirCompetencia() throws Exception{

        getMockMvc().perform(post(URL)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto)))
                .andExpect(status().isCreated());
    }

}
