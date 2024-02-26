package com.example.demospringboot.democrudapp.repository;

import com.example.demospringboot.democrudapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //reprezinta o interfata care gestioneaza entitatea book pentru a stoca si manipula date prin CRUD in DB
//in general ai deja comenzile default, dar daca vrei sa faci un filtru sau o operatie custom nu o sa o poti face daca nu faci asa
public interface BookRepository extends JpaRepository<Book,Long> {//<Entitatea pe care se executa CRUD, tipul cheii primare>
    //o clasa poate sa extinde o alta clasa cu extends
    //o clasa poate sa implementeze mai multe interfete cu implements
    //iar interfata poate extinde o alta interfata cu extends

    //SPRING data la nivel de repo ne permite sa definim modalitati prin care putem sa executam un querry de SQL:
    //1.Folosind sintaxa pe JPQL prin utilizarea adnotarii @query
    //2.Query native prin utilizarea adnotarii @Querry ->diferenta fiind la QUery native prin setarea atributului boolean "nativeQuery" la valoarea TRUE


    //ce ziceam mai sus putem defini aici operatii CRUD custom
    //find all books by aythor
    List<Book> searchBooksByAuthor(String author);
    List<Book> searchBooksByNameAndPrice(String name,double price);

    List<Book> searchBooksByName(String name);

    List<Book> searchBooksByIsbn(String isbn);

}
