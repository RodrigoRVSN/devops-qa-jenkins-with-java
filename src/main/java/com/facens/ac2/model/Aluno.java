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

  public void setPasswordHash(String password) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    this.passwordHash = passwordEncoder.encode(password);
  }
}
