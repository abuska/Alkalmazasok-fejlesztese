package hu.elte.alkfejl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.elte.alkfejl.entity.Book;

@Repository
public interface BookRepository   extends CrudRepository<Book, Long> {
	Iterable<Book> findByCategory(String category);

}
