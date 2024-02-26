package com.example.demospringboot.democrudapp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Getter
//@Setter
//@AllArgsConstructor
@Data //prin asta le contine pe toate de mai sus, chiar mai multe
@Entity
@Table (name = "books") // pui numele book la tabela
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "book_name",nullable = false)
    private String name;
    @Column(name = "book_author",nullable = false)
    private String author;
    @Column(name = "book_price",nullable = false)
    private double price;
    @Column(name = "book_isbn")
    private String isbn;
    @Column(name = "book_category")
    private String category;

    //Many-to-Many relationship with order entity
    @ManyToMany(mappedBy = "bookList",fetch = FetchType.LAZY)
    //lazi load -> incarcarea relatiei nu se va face imediat ci doar atunci cand e nevoie de ea, enitatilie asociate sunt incarcate doar atunci cand sunt accesate prima data
    //eager load -> toate entitatile asociate sunt incarcate din baza de date simultan
    private List<Order> orderList;


}
