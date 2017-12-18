package hu.elte.alkfejl.controller;


import hu.elte.alkfejl.service.AuthorService;
import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.entity.Author;
import hu.elte.alkfejl.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hu.elte.alkfejl.entity.User.Role.*;

@CrossOrigin
	@RestController
	@RequestMapping("/author")
	public class AuthorController {
		
		
		@Autowired
		private AuthorService authorService;
	
		@Role({User.Role.ADMIN, User.Role.USER, User.Role.GUEST})
		@GetMapping("/listall")
		public ResponseEntity<List<Author>> getAllAuthors() {
			List<Author> authors = (List<Author>) authorService.findAll();
			return ResponseEntity.ok(authors);
		}
		
		
		@Role({User.Role.ADMIN})
		@PostMapping("/new")
		public ResponseEntity<Author> addAuthor(@RequestBody(required = true) Author author) {
			return  ResponseEntity.ok(authorService.save(author));
		}
		 
		
	}
