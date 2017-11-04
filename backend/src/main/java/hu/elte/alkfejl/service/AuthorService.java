package hu.elte.alkfejl.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.elte.alkfejl.entity.Author;
import hu.elte.alkfejl.entity.Book;
import hu.elte.alkfejl.entity.BookOrder;
import hu.elte.alkfejl.repository.AuthorRepository;
import hu.elte.alkfejl.repository.BookOrderRepository;
import hu.elte.alkfejl.repository.BookRepository;

 
@Service
@Transactional
public class AuthorService{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author findById(long id) {
		return authorRepository.findOne(id);
	}
	
	public Author save(Author newAuthor) {
		return authorRepository.save(newAuthor);
	}
	
	public Iterable<Author> findAll() {
		return authorRepository.findAll();
	}
	
}
