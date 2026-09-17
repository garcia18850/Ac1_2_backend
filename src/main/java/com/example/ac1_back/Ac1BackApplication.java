package com.example.ac1_back;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1_back.models.Diretor;
import com.example.ac1_back.models.Filme;
import com.example.ac1_back.repositories.DiretorRepository;
import com.example.ac1_back.repositories.FilmeRepository;

@SpringBootApplication
public class Ac1BackApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ac1BackApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(DiretorRepository diretorRepository, FilmeRepository filmeRepository) {
        return args -> {
            Diretor diretor1 = new Diretor("Francis Ford Coppola");
            Diretor diretor2 = new Diretor("Quentin Tarantino");

            diretorRepository.save(diretor1);
            diretorRepository.save(diretor2);

            Filme filme1 = new Filme("Apocalypse Now", 147, diretor1);
            Filme filme2 = new Filme("The Godfather", 175, diretor1);
            Filme filme3 = new Filme("Pulp Fiction", 154, diretor2);

            filmeRepository.save(filme1);
            filmeRepository.save(filme2);
            filmeRepository.save(filme3);

            System.out.println("--- Filmes com duração maior que 150 minutos ---");
            filmeRepository.findByDuracaoGreaterThan(150).forEach(f -> System.out.println(f.getTitulo() + " - " + f.getDuracao() + " min"));

            System.out.println("\n--- Filmes com duração menor ou igual a 155 minutos ---");
            filmeRepository.findByDuracaoLessThanEqual(155).forEach(f -> System.out.println(f.getTitulo() + " - " + f.getDuracao() + " min"));
            System.out.println("\n--- Filmes que começam com 'The' ---");
            filmeRepository.findByTituloStartingWith("The").forEach(f -> System.out.println(f.getTitulo()));

            System.out.println("\n--- Diretores que começam com 'Francis' ---");
            diretorRepository.findByNomeStartingWith("Francis").forEach(d -> System.out.println(d.getNome()));
        };
    }
}
