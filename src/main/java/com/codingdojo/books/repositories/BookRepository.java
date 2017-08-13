package com.codingdojo.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.books.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findByDescriptionContaining(String search);
    Long countByTitleContaining(String search);
    Long deleteByTitleStartingWith(String search);

}	
//This will create a repository for us that will expose the Spring Data JPA.