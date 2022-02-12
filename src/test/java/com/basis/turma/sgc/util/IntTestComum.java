package com.basis.turma.sgc.util;

//import com.basis.turma.service.SgcApplication;
import com.basis.turma.sgc.SgcApplication;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest(classes = SgcApplication.class)
@WebAppConfiguration
@TestConfiguration
@ExtendWith(SpringExtension.class)

public abstract class IntTestComum {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected MockMvc getMockMvc() {
        return mockMvc;
    }
}
