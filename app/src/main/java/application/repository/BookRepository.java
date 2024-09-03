package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
    
}
