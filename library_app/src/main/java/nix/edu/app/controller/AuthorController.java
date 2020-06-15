package nix.edu.app.controller;

import nix.edu.data.entity.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nix.edu.app.service.AuthorService;

@RestController
@RequestMapping("authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        authorService.findAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name")
    public ResponseEntity findAllFirstNameOrLastNameContaining(@RequestParam String name) {
        authorService.findByFirstNameOrLastNameContaining(name);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        authorService.findById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(Long id) {
        authorService.remove(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity saveOrUpdate(@RequestBody Author author){
        authorService.saveOrUpdate(author);
        return ResponseEntity.ok().build();
    }
}
