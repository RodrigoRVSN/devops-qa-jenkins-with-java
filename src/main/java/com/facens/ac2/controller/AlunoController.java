package com.facens.ac2.controller;

import com.facens.ac2.controller.dto.AlunoDTO;
import com.facens.ac2.model.Aluno;
import com.facens.ac2.model.Curso;
import com.facens.ac2.repository.AlunoRepository;
import com.facens.ac2.repository.CursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/alunos")
public class AlunoController {

  private final AlunoRepository repository;
  private final CursoRepository cursoRepository;

  @Autowired
  public AlunoController(AlunoRepository repository, CursoRepository cursoRepository) {
    this.repository = repository;
    this.cursoRepository = cursoRepository;
  }

  @GetMapping
  public List<AlunoDTO> lista() {
    List<Aluno> dto = repository.findAll();
    return AlunoDTO.convert(dto);
  }

  @GetMapping("/{id}")
  public Aluno getAlunoById(@PathVariable Long id) {
    return repository.findById(id).orElse(null);
  }

  @PostMapping
  public AlunoDTO createAluno(@RequestBody Aluno aluno) {
    repository.save(aluno);
    AlunoDTO dto = new AlunoDTO(aluno);
    return dto;
  }

  @PutMapping("/{id}")
  public Aluno updateAluno(
      @PathVariable Long id,
      @RequestBody Aluno updatedAluno) {
    Aluno aluno = repository.findById(id).orElse(null);
    if (aluno != null) {
      aluno.setName(updatedAluno.getName());
      return repository.save(aluno);
    }
    return null;
  }

  @PostMapping("/{aluno_id}/adquire-curso/{curso_id}")
  public Aluno alunoAdquireCurso(
      @PathVariable Long aluno_id,
      @PathVariable Long curso_id) {
    Aluno aluno = repository.findById(aluno_id).orElse(null);
    Curso curso = this.cursoRepository.findById(curso_id).orElse(null);

    System.out.println(aluno + "\n\n" + curso);

    if (aluno != null && curso != null) {
      aluno.adquireCurso(curso);
      return repository.save(aluno);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public void deleteAluno(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
