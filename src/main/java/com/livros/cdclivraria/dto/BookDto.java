package com.livros.cdclivraria.dto;

import com.livros.cdclivraria.config.Uploader;
import com.livros.cdclivraria.model.Author;
import com.livros.cdclivraria.model.Book;
import com.livros.cdclivraria.repositories.AuthorRepository;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class BookDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String subTitulo;

    @Min(10)
    private BigDecimal preco;

    @NotBlank
    private String conteudo;

    @NotBlank
    private String sumario;

    @Min(100)
    private BigDecimal numeroPaginas;

    @NotBlank
    private String isbn;

    @NotNull
    private MultipartFile capa;


    @NotNull
    private Long authorId;



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

    public MultipartFile getCapa() {
        return capa;
    }

    public void setCapa(MultipartFile capa) {
        this.capa = capa;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Book newBook(AuthorRepository authorRepository, Uploader uploader) {
        Author author = authorRepository.findById(authorId).get();
        String linkCapaLivro = uploader.upload(capa);
        return new Book(titulo, subTitulo, preco, conteudo, sumario, numeroPaginas, isbn, "https://google.com", author );
    }
}
