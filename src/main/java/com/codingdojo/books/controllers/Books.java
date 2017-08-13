package com.codingdojo.books.controllers;

import java.util.List;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.books.BookService;
import com.codingdojo.books.models.Book;

@Controller
public class Books {
	private final BookService bookService;
	
	public Books(BookService bookService) {
		this.bookService = bookService;
	}
	// The data is hard coded in BookService.java
    @RequestMapping("/books")
    public String books(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "books.jsp";
    }

    @RequestMapping("/bookslist")
    public String booksList(Model model) {
        List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
            new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
            new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
            new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
            ));
        model.addAttribute("books", books);
        return "bookslist.jsp";
    }
    //Some hard coded books
    @RequestMapping("/booksdiv")
    public String booksDiv(Model model) {
        List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("Algowhores", "Busting your head on software puzzles", "english", 609),
            new Book("Squats", "Scupt your butt to look nice", "english", 80),
            new Book("Moby", "Can get smoked by Obie", "english", 54),
            new Book("Don Quixote", "A Japanese discount store", "nihon", 2006),
            new Book("The Odyssey", "Honda made minivan", "english", 280)
            ));
        model.addAttribute("books", books);
        return "booksdiv.jsp";
    }
    @RequestMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBookById(id);
        if (book != null){
            model.addAttribute("book", book);
            return "editBook.jsp";
        }else{
            return "redirect:/books";
        }
    }
    // route for newBook
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "newBook.jsp";
    }
    // Validate and Post Data  --- BookService.java
    @PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "newBook.jsp";
        }else{
            // Add the book
            return "redirect:/books";
        }
    }
    // Updating data
    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "editBook.jsp";
        }else{
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
    // Deleting Data, Since expects a Long as its argument, we must also edit our controller method to use a Long type id
    @RequestMapping(value="/books/delete/{id}")
    public String destroyBook(@PathVariable("id") Long id) {
        bookService.destroyBook(id);
        return "redirect:/books";
    }
    // Data Repository stuffs from learning platform
    @RequestMapping("/books/{index}")
    public String findBookByIndex(@PathVariable("index") Long index, Model model) {
        model.addAttribute("book", bookService.findBookById(index));
        return "book";
    }


}