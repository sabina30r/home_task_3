package nix.edu.app.service;

import nix.edu.data.entity.Book;
import java.util.List;

public interface BookService extends AbstractService<Book> {

    List<Book> findByBookName(String bookName);
    List<Book> findByAuthor(Long authorId);
}