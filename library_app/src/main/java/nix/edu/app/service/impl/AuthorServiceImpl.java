package nix.edu.app.service.impl;

import nix.edu.data.entity.Author;
import org.springframework.stereotype.Service;
import nix.edu.data.repository.AuthorRepository;
import nix.edu.app.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findByFirstNameOrLastNameContaining(String name) {
        return authorRepository.findByFirstNameOrLastNameContaining(name, name);
    }

    public void saveOrUpdate(Author author) {
        authorRepository.save(author);
    }

    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public void remove(Long id) {
        authorRepository.deleteById(id);
    }

}