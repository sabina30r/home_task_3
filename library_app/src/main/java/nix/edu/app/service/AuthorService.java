package nix.edu.app.service;

import nix.edu.data.entity.Author;

import java.util.List;

public interface AuthorService extends AbstractService<Author> {

    List<Author> findByFirstNameOrLastNameContaining(String name);
}
