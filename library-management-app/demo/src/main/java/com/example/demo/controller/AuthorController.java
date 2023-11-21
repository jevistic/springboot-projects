package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController extends BaseController<Author> {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return create(author);
    }

    // Get author by ID
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable int id) {
        return authorService.getById(id);
    }

    // Update an existing author
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    // Delete an author by ID
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable int id) {
        delete(id);
    }
    @GetMapping("/")
    public List<Author> getAllAuthors(){
        return authorService.getAll();
    }

}
