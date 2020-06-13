package nix.edu.data.repository;

import nix.edu.data.entity.Author;

import java.util.List;

public interface AuthorRepository extends AbstractRepository<Author> {
    List<Author> findByFirstNameOrLastNameContaining(String firstName, String lastName);
}
