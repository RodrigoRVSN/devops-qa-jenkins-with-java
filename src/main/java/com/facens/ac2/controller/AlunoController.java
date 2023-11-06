package com.facens.ac2.controller;

import com.facens.ac2.controller.dto.AlunoDTO;
import com.facens.ac2.model.Aluno;
import com.facens.ac2.repository.AlunoRepository;
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

  @Autowired
  private AlunoRepository alunoRepository;

  @GetMapping
  public List<AlunoDTO> lista() {
    List<Aluno> alunos = alunoRepository.findAll();
    return AlunoDTO.convert(alunos);
  }

  @GetMapping("/{id}")
  public Aluno getAlunoById(@PathVariable Long id) {
    return alunoRepository.findById(id).orElse(null);
  }

  @PostMapping
  public Aluno createAluno(@RequestBody Aluno aluno) {
    return alunoRepository.save(aluno);
  }

  @PutMapping("/{id}")
  public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno updatedAluno) {
    Aluno aluno = alunoRepository.findById(id).orElse(null);
    if (aluno != null) {
      aluno.setName(updatedAluno.getName());
      return alunoRepository.save(aluno);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public void deleteAluno(@PathVariable Long id) {
    alunoRepository.deleteById(id);
  }
}
