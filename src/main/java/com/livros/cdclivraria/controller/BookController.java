package com.livros.cdclivraria.controller;

import com.livros.cdclivraria.config.Uploader;
import com.livros.cdclivraria.dto.BookDto;
import com.livros.cdclivraria.model.Book;
import com.livros.cdclivraria.repositories.AuthorRepository;
import com.livros.cdclivraria.repositories.BookRepository;
import com.livros.cdclivraria.services.BookService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;
    private final AuthorRepository authorRepository;
    private final Uploader uploader;
    private final BookRepository bookRepository;

    public BookController(BookService bookService, AuthorRepository authorRepository, AuthorRepository authorRepository1, Uploader uploader, BookRepository bookRepository) {
        this.bookService = bookService;
        this.authorRepository = authorRepository1;
        this.uploader = uploader;
        this.bookRepository = bookRepository;
    }



  @PostMapping("/api/livros")
  @Transactional
    public ResponseEntity<Object> saveBook(@Valid BookDto bookDto){
        //estabelecendo condições:
      if (bookService.existsByIsbn(bookDto.getIsbn())){
          return ResponseEntity.status(HttpStatus.CONFLICT).body("Numero de isbn já cadastrado");
      }
        Book book = bookDto.newBook(authorRepository,uploader);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
    }


    
}
