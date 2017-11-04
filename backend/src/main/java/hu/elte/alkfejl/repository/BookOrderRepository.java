package hu.elte.alkfejl.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.elte.alkfejl.entity.BookOrder;
import hu.elte.alkfejl.entity.User;

@Repository
public interface BookOrderRepository   extends CrudRepository<BookOrder, Long>{ 
		List<BookOrder> findByUserId(Long id);

}
