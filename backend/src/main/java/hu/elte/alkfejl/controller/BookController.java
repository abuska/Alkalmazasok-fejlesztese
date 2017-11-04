package hu.elte.alkfejl.controller;


import hu.elte.alkfejl.service.BookService;
import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hu.elte.alkfejl.entity.User.Role.*;
	
	@RestController
	@RequestMapping("/book")
	public class BookController {
		
		
		@Autowired
		private BookService bookService;
	
		@Role({ADMIN, USER, GUEST})
		@GetMapping("/listall")
		public ResponseEntity<List<Book>> getAllBooks() {
			List<Book> books = (List<Book>) bookService.findAll();
			return ResponseEntity.ok(books);
		}
		
		@Role({ADMIN, USER, GUEST})
		@GetMapping("/{id}")
		public ResponseEntity<Book> getBookById(@PathVariable( required=true, value="id" ) int  id) throws IllegalArgumentException {
			Book book = bookService.findById(new Long(id));
				try {
				if(book!=null) {
					return ResponseEntity.ok(book);
				}else {
					return  ResponseEntity.ok(null);
				}
			}
			catch(IllegalArgumentException e) {
				return  ResponseEntity.ok(null);
			}
		}
		
		
		@Role({ADMIN})
		@PostMapping("/new")
		public ResponseEntity<Book> addBook(@RequestBody(required = true) Book book) {
			return  ResponseEntity.ok(bookService.saveBook(book));
		}
		
		@Role({ADMIN, USER, GUEST})
		@GetMapping("/category/{category}")
		public ResponseEntity<List<Book>> getBookByCategory(@PathVariable( required=true, value="category" ) String category) {
			List<Book> books = (List<Book>) bookService.findByCategory(category);
			return ResponseEntity.ok(books);
			
		}
		
		
	/*	@Role({ADMIN, USER, GUEST})
		@GetMapping("/filterby")
		public ResponseEntity<List<Book>> filterBooksByTColumn(@RequestBody(required = true) String parameter){
			return ResponseEntity.ok(bookService.find(parameter));
			return null;
		}
	*/
		
		  
		  
		
	}
