package com.example.demospringboot.democrudapp.controller;

import com.example.demospringboot.democrudapp.model.Book;
import com.example.demospringboot.democrudapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController //@RestController Vs @Controller -> Spring rest api
//@RestController = @Controller + @ResponseBody
//@RestController ofera suport pentru RestAPI
@RequestMapping("/api/books")
public class BookController {
    //Controller-ul este responsabil pentru a gestiona requesturile de HTTP care vin de la client(aplicatia web) si de a returna un raspuns HTTP inapoi catre client
    //comunicare intre frontend si backend e realizata prin protocolul HTTP de tipul request / response

    //dependency injection using annotation @RequiredArgsConstructor (DI through constructor)
    private final BookService bookService;

    //Implement HTTP rest apis(Http verbs): GET(@GetMapping), POST(@PostMapping), PUT(@PutMapping), DELETE(@DeleteMapping)

    //GET endpoint -> http://localhost:8080/api/books =am facut asta prin requestmapping-ul de sus
    //definesti un fel de ruta
    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.readAllBooks(), HttpStatus.OK);
    }



}
