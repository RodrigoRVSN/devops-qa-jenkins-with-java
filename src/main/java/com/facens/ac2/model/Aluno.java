package com.facens.ac2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alunos")
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String email;
  private String password;
  private String passwordHash;
  private Plano plano = Plano.FREE;

  @ManyToMany
  @JoinTable(
    name = "aluno_curso",
    joinColumns = @JoinColumn(name = "aluno_id"),
    inverseJoinColumns = @JoinColumn(name = "curso_id")
  )
  private List<Curso> cursos = new ArrayList<>();

  public Aluno(String name, String email, String password) {
    this.name = name;
    this.email = email;
    setPasswordHash(password);
  }

  private void setPasswordHash(String password) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    passwordHash = passwordEncoder.encode(password);
  }

  public void adquireCurso(Curso curso) {
    cursos.add(curso);
  }

  public void verificaPlano() {
    if (this.getCursos().size() > 11) {
      plano = Plano.PREMIUM;
    } else {
      plano = Plano.FREE;
    }
  }

  public void showCursos() {
    for (Curso curso : cursos) {
      curso.show();
      System.out.println("");
    }
  }

}
