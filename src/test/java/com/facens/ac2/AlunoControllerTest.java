package com.facens.ac2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.facens.ac2.model.Aluno;
import com.facens.ac2.repository.AlunoRepository;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoRepository repository;

    @Test
    public void shouldReturnListOfAlunos() throws Exception {
        Aluno aluno1 = new Aluno("John Doe", "john@mail.com", "any_password");
        Aluno aluno2 = new Aluno("John Doe", "john@mail.com", "any_password");
        List<Aluno> alunos = Arrays.asList(aluno1, aluno2);

        given(repository.findAll()).willReturn(alunos);

        mockMvc.perform(get("/alunos"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(alunos.size()));
    }
}