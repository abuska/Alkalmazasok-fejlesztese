package hu.elte.alkfejl.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.elte.alkfejl.entity.Book;
import hu.elte.alkfejl.entity.BookOrder;
import hu.elte.alkfejl.repository.BookOrderRepository;
import hu.elte.alkfejl.repository.BookRepository;

 
@Service
@Transactional
public class BookOrderService{
	
	@Autowired
	private BookOrderRepository bookOrderRepository;
	

	public BookOrder findById(long id) {
		return bookOrderRepository.findOne(id);
	}
	
	public BookOrder saveOrder(BookOrder newBookOrder) {
		return bookOrderRepository.save(newBookOrder);
	}
	
	public BookOrder changeStatus(BookOrder bookOrder, String Status) {
		bookOrder.setStatus(Status);
		return bookOrderRepository.save(bookOrder);
	}
	
	public Iterable<BookOrder> findAll() {
		return bookOrderRepository.findAll();
	}
	
	public List<BookOrder> findByUserId(long id){
		return bookOrderRepository.findByUserId(id);
	}
}
