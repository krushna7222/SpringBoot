package com.respAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.respAPI.entity.Book;
import com.respAPI.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@PostMapping("/addbook")
	public Book addBook(@RequestBody Book bk) {
		
		Book addedBook = bookService.addBook(bk);
		
		return addedBook;
	}
	
	@GetMapping("/allbook")
	public List<Book> allBook() {
		
		List<Book> allBook = bookService.allBook();
		
		return allBook;
	}
	
	@GetMapping("/getSingleBook/{id}")
	public Book getSingleBook(@PathVariable("id") int i) {
		
		Book singleBook = bookService.getSingleBook(i);
		
		return singleBook;
	}
	
	@PutMapping("/editbook/{id}")
	public Book editBook(@PathVariable("id") int i,@RequestBody Book bk) {
		
		Book editedBook = bookService.editBook(i, bk);
		
		return editedBook;
	}
	
	@DeleteMapping("/delete/{id}")
	public String editBook(@PathVariable("id") int i) {
		
			bookService.deleteBook(i);
		
		return "Object Deleted Success...";
	}
	
}
