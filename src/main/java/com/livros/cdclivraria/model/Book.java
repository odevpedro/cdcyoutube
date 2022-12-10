package com.livros.cdclivraria.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;


@Entity
@Table(name = "TB_BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 100)
    private String titulo;

    @NotBlank
    private String subTitulo;

    @NotNull @Min(20)
    private BigDecimal preco;

    @NotBlank
    private String conteudo;

    @NotBlank
    private String sumario;

    @NotNull
    private BigDecimal numeroPaginas;

    @NotBlank
    private String isbn;

    @NotBlank @URL
    private String linkCapaLivro;

    @ManyToOne
    @NotNull
    private Author author;

    public String getLinkCapaLivro() {
        return linkCapaLivro;
    }

    public void setLinkCapaLivro(String linkCapaLivro) {
        this.linkCapaLivro = linkCapaLivro;
    }



    /*
    @ManyToOne
    private @NotNull Author autor;
*/

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public BigDecimal getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(BigDecimal numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }




    public Book(@NotBlank @Size(max = 100) String titulo, @NotBlank @Size(max = 50) String subTitulo,
                @NotBlank @Size(min = 20) BigDecimal preco, @NotBlank String conteudo,
                @NotBlank String sumario, @NotBlank @Size(min = 100) BigDecimal numeroPaginas,
                @NotBlank String isbn, @NotBlank @URL String linkCapaLivro, @NotNull Author author) {
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.preco = preco;
        this.conteudo = conteudo;
        this.sumario = sumario;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.linkCapaLivro = linkCapaLivro;
        this.author = author;

    }

    public Book(){

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", subTitulo='" + subTitulo + '\'' +
                ", preco=" + preco +
                ", conteudo='" + conteudo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", linkCapaLivro='" + linkCapaLivro + '\'' +
                ", author=" + author +
                '}';
    }
}
