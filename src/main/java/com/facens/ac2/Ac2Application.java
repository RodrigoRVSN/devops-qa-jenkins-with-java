package com.facens.ac2;

import com.facens.ac2.model.Curso;
import com.facens.ac2.repository.CursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ac2Application {
	public static void main(String[] args) {
		SpringApplication.run(Ac2Application.class, args);
	}
}
