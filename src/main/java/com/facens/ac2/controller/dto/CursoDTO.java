package com.facens.ac2.controller.dto;

import com.facens.ac2.model.Curso;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CursoDTO {

  private Long id;
  private String name;

  public CursoDTO(Curso curso) {
    super();
    this.id = curso.getId();
    this.name = curso.getName();
  }

  public static List<CursoDTO> convert(List<Curso> cursos) {
    return cursos.stream().map(CursoDTO::new).collect(Collectors.toList());
  }
}
