package com.livros.cdclivraria.dto;

import com.livros.cdclivraria.model.Author;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public class AuthorDto {

    @NotBlank
    private String nome;

    @NotBlank
    @URL
    private String linkGithub;

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public String getLinkGithub() {
        return linkGithub;
    }

    public void setLinkGithub(String linkGithub) {
        this.linkGithub = linkGithub;
    }
    public Author newAuthor() {
        return new Author(nome, linkGithub);
    }
}
