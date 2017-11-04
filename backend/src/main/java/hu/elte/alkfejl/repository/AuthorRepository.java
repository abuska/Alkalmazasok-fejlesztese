package hu.elte.alkfejl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.elte.alkfejl.entity.Author;

@Repository
public interface AuthorRepository   extends CrudRepository<Author, Long> {

}
