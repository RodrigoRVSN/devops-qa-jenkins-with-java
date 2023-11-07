package com.facens.ac2;

import com.facens.ac2.model.Curso;
import com.facens.ac2.repository.CursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ac2Application {

  public static void main(String[] args) {
    SpringApplication.run(Ac2Application.class, args);
  }

  @Bean
  public CommandLineRunner initData(CursoRepository cursoRepository) {
    return args -> {
      Curso portugues = new Curso("Português");
      Curso matematica = new Curso("Matemática");
      Curso ciencias = new Curso("Ciências");
      Curso historia = new Curso("História");
      Curso geografia = new Curso("Geografia");
      Curso educacaoFisica = new Curso("Educação Física");
      Curso religiao = new Curso("Religião");
      Curso filosofia = new Curso("Filosofia");
      Curso artes = new Curso("Artes");
      Curso desenvolvimentoPessoal = new Curso("Desenvolvimento Pessoal");

      cursoRepository.save(portugues);
      cursoRepository.save(matematica);
      cursoRepository.save(ciencias);
      cursoRepository.save(historia);
      cursoRepository.save(geografia);
      cursoRepository.save(educacaoFisica);
      cursoRepository.save(religiao);
      cursoRepository.save(filosofia);
      cursoRepository.save(artes);
      cursoRepository.save(desenvolvimentoPessoal);
    };
  }
}
