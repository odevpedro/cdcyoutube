package com.livros.cdclivraria.controller;

import com.livros.cdclivraria.config.Uploader;
import com.livros.cdclivraria.dto.BookDto;
import com.livros.cdclivraria.model.Book;
import com.livros.cdclivraria.repositories.AuthorRepository;
import com.livros.cdclivraria.services.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;
    private final AuthorRepository authorRepository;
    private final Uploader uploader;

    public BookController(BookService bookService, AuthorRepository authorRepository, Uploader uploader) {
        this.bookService = bookService;
        this.authorRepository = authorRepository;
        this.uploader = uploader;
    }



  @PostMapping("/api/livros")
    public void save(@Valid BookDto bookDto){
        Book book = bookDto.newBook(authorRepository,uploader);
      System.out.println(book);
    }
}
