package com.example.ac1_back.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac1_back.models.Diretor;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {

    List<Diretor> findByNomeStartingWith(String nome);
}
