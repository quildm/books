package com.codingdojo.books.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.books.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
}	
//This will create a repository for us that will expose the Spring Data JPA.