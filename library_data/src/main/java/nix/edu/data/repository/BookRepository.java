package nix.edu.data.repository;

import nix.edu.data.entity.Author;
import nix.edu.data.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends AbstractRepository<Book> {

    List<Book> findByBookName(String bookName);
    @Query("select book from Book book " +
            "join book.authorList author " +
            "where author.id = :authorId " +
            "order by book.id desc")
    List<Book> findByAuthor(@Param("authorId") Long authorId);

}
