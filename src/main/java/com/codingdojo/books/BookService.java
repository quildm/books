package com.codingdojo.books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.codingdojo.books.models.Book;
import com.codingdojo.books.repositories.BookRepository;
@Service
public class BookService {
	private BookRepository bookRepository;
	
	 public BookService(BookRepository bookRepository){
	        this.bookRepository = bookRepository;
	    }
    // initialize the books variable with values
    private List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
            new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
            new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
            new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
            ));
    
    // returns all the books
    public List<Book> allBooks() {
    	return (List<Book>) bookRepository.findAll();
    	//return books;
    }

    public Book findBookById(Long index) {
        return bookRepository.findOne(index);
    }
    
    // Validate and Post Data -- Books.java
    public void addBook(Book book) {
    	bookRepository.save(book);
    	//books.add(book);
    }
    // Updating data
    public void updateBook(Book book) {
        bookRepository.save(book);
    }
    // Deleting Data
    public void destroyBook(Long id) {
//        if (id < books.size()){
//            books.remove(id);
//        }
    	bookRepository.delete(id);
    }
    
}