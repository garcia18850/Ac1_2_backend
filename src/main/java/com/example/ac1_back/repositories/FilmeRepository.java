package com.example.ac1_back.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac1_back.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findByDuracaoGreaterThan(Integer duracao);

    List<Filme> findByDuracaoLessThanEqual(Integer duracao);

    List<Filme> findByTituloStartingWith(String titulo);
}
