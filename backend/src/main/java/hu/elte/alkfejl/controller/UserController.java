package hu.elte.alkfejl.controller;


import hu.elte.alkfejl.service.UserService;
import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static hu.elte.alkfejl.entity.User.Role.*;
	
	@RestController
	@RequestMapping("/user")
	public class UserController {
		
		
		@Autowired
		private UserService userService;
		
		private AuthController authController;

		/**
		 * Az összes felhasználó listázása.
		 * 
		 * @return JSON az összes felhasználóval
		 */
		@Role({ADMIN})
		@GetMapping("/listall")
		public ResponseEntity<List<User>> getAllUsers() {
			List<User> users = (List<User>) userService.findAll();
			return ResponseEntity.ok(users);
		}
		
		
		@Role({GUEST})
		@PostMapping("/register")
		    public String register(@RequestBody User user) {
		        Optional<User> dbUser =
		        		userService.findByEmailAndPassword(user.getEmail(),
		                                                  user.getPassword());
		        if (!dbUser.isPresent()) {
		        	userService.saveUser(user);
		            return "user with email address:" +user.getEmail()+ " registered";
		        } else {
		            return null;
		        }
		    }
		@Role({ADMIN, USER, GUEST})
		  @PostMapping("/login")
		  	public String login(@RequestBody String email, String password) {
			 User user = userService.findByEmailAndPassword(email, password);
			  return authController.login(user);
		  }
		  
		@Role({ADMIN, USER})
		@PostMapping("/edit")
		public ResponseEntity<User> editUser(@RequestBody User user) {
			return ResponseEntity.ok(userService.saveUser(user));
		}
		
		  
		
	}
