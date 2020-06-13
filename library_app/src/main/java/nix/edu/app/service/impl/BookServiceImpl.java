package nix.edu.app.service.impl;

import nix.edu.data.entity.Book;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import nix.edu.data.repository.AuthorRepository;
import nix.edu.data.repository.BookRepository;
import nix.edu.app.service.BookService;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> findByBookName(String bookName) {
        return bookRepository.findByBookName(bookName);
    }

    public List<Book> findByAuthor(Long authorId) {
        return bookRepository.findByAuthor(authorId);
    }

    public void saveOrUpdate(Book book) {
        bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findAll() {
        return bookRepository.findAll(Sort.by("id"));
    }

    public void remove(Long id) {
        bookRepository.deleteById(id);
    }
}