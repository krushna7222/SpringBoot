package com.respAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.respAPI.entity.Book;
import com.respAPI.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book addBook(Book bk) {
		
		Book addedBook = bookRepository.save(bk);

		return addedBook;
	}

	public List<Book> allBook() {
		List<Book> allBook = bookRepository.findAll();
		return allBook;
	}

	public Book editBook(int id , Book bk) {
		Optional<Book> opbook = bookRepository.findById(id); 
		Book book = opbook.get();
				
		book.setName(bk.getName());
		book.setAuthor(bk.getAuthor());
		book.setPrice(bk.getPrice());
		
		Book newBook = bookRepository.save(book);
		
		return newBook;
	}

	public Book getSingleBook(int id) {

		Optional<Book> opbook = bookRepository.findById(id); 
		Book book = opbook.get();
		
		return book;
	}

	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		
		bookRepository.deleteById(id);
		
	}

}
