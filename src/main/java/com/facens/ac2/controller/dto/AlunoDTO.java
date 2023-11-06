package com.facens.ac2.controller.dto;

import com.facens.ac2.model.Aluno;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoDTO {

  private Long id;
  private String name;

  public AlunoDTO(Aluno aluno) {
    super();
    this.id = aluno.getId();
    this.name = aluno.getName();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public static List<AlunoDTO> convert(List<Aluno> usuarios) {
    return usuarios.stream().map(AlunoDTO::new).collect(Collectors.toList());
  }
}
