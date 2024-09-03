package application.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import application.model.Book;
import application.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepo;

    @GetMapping
    public Iterable<Book> getAll() {
        return bookRepo.findAll();
    }

    @GetMapping("/{id}")
    public Book getOne(@PathVariable long id) {
        Optional<Book> result = bookRepo.findById(id);

        if(result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Book not found."
            );
        }
        return result.get();
    }
}
