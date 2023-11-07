package com.facens.ac2;

import com.facens.ac2.model.Aluno;
import com.facens.ac2.model.Curso;
import com.facens.ac2.repository.AlunoRepository;
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
  public CommandLineRunner initCursos(CursoRepository cursoRepository) {
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

  @Bean
  public CommandLineRunner initAlunos(AlunoRepository alunoRepository) {
    return args -> {
      Aluno test01 = new Aluno("Test 01", "test01@mail.com", "senhaForte01");
      Aluno test02 = new Aluno("Test 02", "test02@mail.com", "senhaForte02");
      Aluno test03 = new Aluno("Test 03", "test03@mail.com", "senhaForte03");
      Aluno test04 = new Aluno("Test 04", "test04@mail.com", "senhaForte04");
      Aluno test05 = new Aluno("Test 05", "test05@mail.com", "senhaForte05");

      // test01.adquireCurso(new Curso("test"));

      alunoRepository.save(test01);
      alunoRepository.save(test02);
      alunoRepository.save(test03);
      alunoRepository.save(test04);
      alunoRepository.save(test05);
    };
  }
}
