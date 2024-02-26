package com.example.demospringboot.democrudapp.service;

import com.example.demospringboot.democrudapp.model.Book;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Optional;

public interface BookService {
    // HTTP verbs: GET, POST, PUT, DELETE, PATCH
    //GET - READ
    //POST - CREATE
    //PUT - UPDATE
    //DELETE - DELETE

    //this methods will call the default CRUD implementation define in CrudRepository interface
    //read all books from DB -> cine va trigger-uri -> GET HTTp endpoint
    List<Book> readAllBooks();

    //Read data for a book by id -> GET (by id) HTTP endpoint
    Optional<Book> getBookById(Long id);

    //CREATE new book and save it to DB -> POST HTTP endpoint
    Book saveBook(Book book);

    //DELETE book by id -> DELETE (by id) HTTP endpoint
    void deleteBookById(Long id);

    //UPDATE a book -> PUT HTTP endpoint
    Book updateBook(Book book);

    //custom CRUD methods defined
    List<Book> getAllBooksByName(String name);

    List<Book> getAllBooksByIsbn(String isbn);

}
