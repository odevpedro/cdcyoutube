package com.livros.cdclivraria.repositories;

import com.livros.cdclivraria.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
