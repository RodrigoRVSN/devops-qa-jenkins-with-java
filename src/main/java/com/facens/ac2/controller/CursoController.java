package com.facens.ac2.controller;

import com.facens.ac2.controller.dto.CursoDTO;
import com.facens.ac2.model.Curso;
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
@RequestMapping("/cursos")
public class CursoController {

  @Autowired
  private CursoRepository repository;

  @GetMapping
  public List<CursoDTO> lista() {
    List<Curso> dto = repository.findAll();
    return CursoDTO.convert(dto);
  }

  @GetMapping("/{id}")
  public Curso getCursoById(@PathVariable Long id) {
    return repository.findById(id).orElse(null);
  }

  @PostMapping
  public CursoDTO createCurso(@RequestBody Curso curso) {
    repository.save(curso);
    CursoDTO dto = new CursoDTO(curso);
    return dto;
  }

  @PutMapping("/{id}")
  public Curso updateCurso(
    @PathVariable Long id,
    @RequestBody Curso updatedCurso
  ) {
    Curso curso = repository.findById(id).orElse(null);
    if (curso != null) {
      curso.setName(updatedCurso.getName());
      return repository.save(curso);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public void deleteCurso(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
