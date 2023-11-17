package com.facens.ac2;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.facens.ac2.controller.AlunoController;
import com.facens.ac2.model.Aluno;
import com.facens.ac2.model.Curso;
import com.facens.ac2.repository.AlunoRepository;
import com.facens.ac2.repository.CursoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class AlunoControllerTest {

  @Mock
  private AlunoRepository alunoRepository;

  @Mock
  private CursoRepository cursoRepository;

  @InjectMocks
  private AlunoController alunoController;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(alunoController).build();
    new ObjectMapper();
  }

  @Test
  public void testLista() throws Exception {
    when(alunoRepository.findAll()).thenReturn(Collections.emptyList());

    mockMvc
      .perform(MockMvcRequestBuilders.get("/alunos"))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(0));

    verify(alunoRepository, times(1)).findAll();
  }

  @Test
  public void testGetAlunoById() throws Exception {
    Long alunoId = 1L;
    Aluno aluno = new Aluno();
    aluno.setId(alunoId);

    when(alunoRepository.findById(alunoId))
      .thenReturn(java.util.Optional.of(aluno));

    mockMvc
      .perform(MockMvcRequestBuilders.get("/alunos/{id}", alunoId))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(alunoId));

    verify(alunoRepository, times(1)).findById(alunoId);
  }

  // TO-DO: resolve this issue

  // @Test
  // public void testCreateAluno() throws Exception {
  //   objectMapper = new ObjectMapper();
  //   Aluno aluno = new Aluno();
  //   aluno.setId(10L);
  //   aluno.setName("John Doe");

  //   when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

  //   mockMvc
  //     .perform(
  //       MockMvcRequestBuilders
  //         .post("/alunos")
  //         .contentType(MediaType.APPLICATION_JSON)
  //         .content(objectMapper.writeValueAsString(aluno))
  //     )
  //     .andDo(MockMvcResultHandlers.print())
  //     .andExpect(MockMvcResultMatchers.status().isOk())  
  //     .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
  //     .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"));

  //   verify(alunoRepository, times(1)).save(any(Aluno.class));
  // }

  // @Test
  // public void testUpdateAluno() throws Exception {
  //   Long alunoId = 1L;
  //   Aluno aluno = new Aluno();
  //   aluno.setId(alunoId);
  //   aluno.setName("John Doe");

  //   when(alunoRepository.findById(alunoId))
  //     .thenReturn(java.util.Optional.of(aluno));
  //   when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

  //   Aluno updatedAluno = new Aluno();
  //   updatedAluno.setName("Jane Doe");

  //   mockMvc
  //     .perform(
  //       MockMvcRequestBuilders
  //         .put("/alunos/{id}", alunoId)
  //         .contentType(MediaType.APPLICATION_JSON)
  //         .content(objectMapper.writeValueAsString(updatedAluno))
  //     )
  //     .andExpect(MockMvcResultMatchers.status().isOk())
  //     .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(alunoId))
  //     .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Jane Doe"));

  //   verify(alunoRepository, times(1)).findById(alunoId);
  //   verify(alunoRepository, times(1)).save(any(Aluno.class));
  // }

  @Test
  public void testAlunoAdquireCurso() throws Exception {
    Long alunoId = 1L;
    Long cursoId = 2L;

    Aluno aluno = new Aluno();
    aluno.setId(alunoId);
    Curso curso = new Curso();
    curso.setId(cursoId);

    when(alunoRepository.findById(alunoId))
      .thenReturn(java.util.Optional.of(aluno));
    when(cursoRepository.findById(cursoId))
      .thenReturn(java.util.Optional.of(curso));
    when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

    mockMvc
      .perform(
        MockMvcRequestBuilders.post(
          "/alunos/{aluno_id}/adquire-curso/{curso_id}",
          alunoId,
          cursoId
        )
      )
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(alunoId));

    verify(alunoRepository, times(1)).findById(alunoId);
    verify(cursoRepository, times(1)).findById(cursoId);
    verify(alunoRepository, times(1)).save(any(Aluno.class));
  }

  @Test
  public void testDeleteAluno() throws Exception {
    Long alunoId = 1L;

    mockMvc
      .perform(MockMvcRequestBuilders.delete("/alunos/{id}", alunoId))
      .andExpect(MockMvcResultMatchers.status().isOk());

    verify(alunoRepository, times(1)).deleteById(alunoId);
  }
}
