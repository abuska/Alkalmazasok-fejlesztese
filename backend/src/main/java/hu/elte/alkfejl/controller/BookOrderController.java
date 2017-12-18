package hu.elte.alkfejl.controller;


import hu.elte.alkfejl.service.BookOrderService;
import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.entity.BookOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import static hu.elte.alkfejl.entity.User.Role.*;

@CrossOrigin
	@RestController
	@RequestMapping("/bookorder")
	public class BookOrderController {
		
		
		@Autowired
		private BookOrderService bookOrderService;
	
		@Role({ADMIN})
		@GetMapping("/listall")
		public ResponseEntity<List<BookOrder>> getAllOrders() {
			List<BookOrder> orders = (List<BookOrder>) bookOrderService.findAll();
			return ResponseEntity.ok(orders);
		}
		
		
		@Role({ADMIN, USER})
		@PostMapping("/new")
		public ResponseEntity<BookOrder> addOrder(@RequestBody(required = true) BookOrder newBookOrder) {
			return  ResponseEntity.ok(bookOrderService.saveOrder(newBookOrder));
		}
		
		@Role({ADMIN, USER})
		@PostMapping("/oldorders")
		public ResponseEntity<List<BookOrder>> getOldOrders(@RequestBody(required = true) long id){
			return ResponseEntity.ok(bookOrderService.findByUserId(id));
			
		}
		
		@Role({ADMIN})
		@PostMapping("/updatestatus")
		public ResponseEntity<BookOrder> updateStatus(@RequestBody(required = true) String payload)throws JsonParseException, JsonMappingException, IOException {
			  ObjectMapper objectMapper = new ObjectMapper();
			  JsonNode node = objectMapper.readValue(payload, JsonNode.class);
			  String newStatus = node.get("newStatus").toString();
			  JsonNode bookOrderjson = node.get("bookOrder");
			  BookOrder modifiableBookOrder = objectMapper.convertValue(bookOrderjson, BookOrder.class);
			  modifiableBookOrder.setStatus(newStatus);
			  return ResponseEntity.ok(bookOrderService.saveOrder(modifiableBookOrder));
		}
		 
		
	}
