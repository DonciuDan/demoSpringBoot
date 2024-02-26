package com.example.demospringboot.democrudapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "order_name")
    private String name;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "order_total")
    private double total;
    private int quantity;
    private String status;

    //Many-to-One relationship with customer entity
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    private Customer customer;

    //Many-to-Many relationship with book entity
    @ManyToMany
    @JoinTable(name = "orders_books",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    //Joincolumns se refera la join cu cheia primara din tabela curenta(orders)
    //inversjoincolumns se refera la join cu FK-ul a tabelei books
    private List<Book> bookList;

}
