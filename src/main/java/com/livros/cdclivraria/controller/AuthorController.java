package com.livros.cdclivraria.controller;

import com.livros.cdclivraria.dto.AuthorDto;
import com.livros.cdclivraria.model.Author;
import com.livros.cdclivraria.repositories.AuthorRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {


    private final AuthorRepository authorRepository;

    @PersistenceContext
    private EntityManager manager;

    public AuthorController(AuthorRepository authorRepository, EntityManager manager) {
        this.authorRepository = authorRepository;
        this.manager = manager;
    }

    @PostMapping(value = "/api/autor")
    @Transactional
    public void novo(@Valid @RequestBody AuthorDto authorForm) {
        Author author = authorForm.newAuthor();
        System.out.println(author);
        authorRepository.save(author);
    }

}