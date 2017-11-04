package hu.elte.alkfejl.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.elte.alkfejl.entity.Book;
import hu.elte.alkfejl.repository.BookRepository;

 
@Service
@Transactional
public class BookService{
	
	@Autowired
	private BookRepository bookRepository;
	

	public Book findById(long id) {
		return bookRepository.findOne(id);
	}
	
	public Iterable<Book> findByCategory(String category) {
		return bookRepository.findByCategory(category);
	}
	
	public Book saveBook(Book newBook) {
		return bookRepository.save(newBook);
	}
	
	public void deleteBook(Book delBook) {
		 bookRepository.delete(delBook);
	}
	
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}
}
