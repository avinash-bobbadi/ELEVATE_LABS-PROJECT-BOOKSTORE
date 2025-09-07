package com.Avinash.BookStore.Controller;
import com.Avinash.BookStore.model.Book;
import com.Avinash.BookStore.repository.AuthorRepository;
import com.Avinash.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public Page<Book> getAllBooks(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        if (book.getAuthor() != null && book.getAuthor().getId() != 0) {
            var author = authorRepository.findById((long) book.getAuthor().getId()).orElseThrow();
            book.setAuthor(author);
        }
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(bookDetails.getTitle());
        book.setGenre(bookDetails.getGenre());
        book.setPrice(bookDetails.getPrice());
        if (bookDetails.getAuthor() != null && bookDetails.getAuthor().getId() != 0) {
            var author = authorRepository.findById((long) bookDetails.getAuthor().getId()).orElseThrow();
            book.setAuthor(author);
        }
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}

