package com.facens.ac2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private double nota01 = 0.0;
  private double nota02 = 0.0;
  private double notaFinal = 0.0;
  private double media = 0.0;

  public Curso() {}

  public Curso(String name) {}

  public double getMedia() {
    this.media = (this.nota01 + this.nota02 + this.notaFinal) / 3;
    return this.media;
  }
}
