package com.facens.ac2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private double nota01 = 0.0;
  private double nota02 = 0.0;
  private double notaFinal = 0.0;
  private double media = 0.0;

  public Curso(String name) {
    this.name = name;
  }

  public boolean estaAprovado() {
    double media = calcularMedia();
    return media >= 7.5;
  }

  public double calcularMedia() {
    this.media = (this.nota01 + this.nota02 + this.notaFinal) / 3;
    return this.media;
  }
}
