package nix.edu.app.controller;

import nix.edu.data.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nix.edu.app.service.BookService;

@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        bookService.findAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name")
    public ResponseEntity findByBookName(@RequestParam String name) {
        bookService.findByBookName(name);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity findByAuthor(@PathVariable Long id) {
        bookService.findByAuthor(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity remove(Long id) {
        bookService.remove(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity saveOrUpdate(@RequestBody Book book){
        bookService.saveOrUpdate(book);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        bookService.remove(id);
        return ResponseEntity.ok().build();
    }
}
