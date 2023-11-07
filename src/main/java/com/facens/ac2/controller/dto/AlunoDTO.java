package com.facens.ac2.controller.dto;

import com.facens.ac2.model.Aluno;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AlunoDTO {

  private Long id;
  private String name;
  private String email;

  public AlunoDTO(Aluno aluno) {
    super();
    this.id = aluno.getId();
    this.name = aluno.getName();
    this.email = aluno.getEmail();
  }

  public static List<AlunoDTO> convert(List<Aluno> alunos) {
    return alunos.stream().map(AlunoDTO::new).collect(Collectors.toList());
  }
}
