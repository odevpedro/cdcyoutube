package com.livros.cdclivraria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotBlank String nome;
    private @NotBlank @URL String linkGithub;

    @PastOrPresent
    private LocalDateTime createdAt = LocalDateTime.now();

    public Author(@NotBlank String nome, @NotBlank @URL String linkGithub) {
        this.nome = nome;
        this.linkGithub = linkGithub;
    }

    Author(){

    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", linkGithub='" + linkGithub + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }


}