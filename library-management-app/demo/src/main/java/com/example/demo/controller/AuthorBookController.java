package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.AuthorBook;
import com.example.demo.service.AuthorBookService;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authorbook")
public class AuthorBookController extends BaseController<AuthorBook> {
    @Autowired
    private AuthorBookService authorBookService;

    @PostMapping("/")
    public ResponseEntity<AuthorBook> createAuthorBook(@RequestBody AuthorBook authorBook) {
        return create(authorBook);
    }


    @GetMapping("/{id}")
    public AuthorBook getAuthorBookById(@PathVariable int id) {
        return authorBookService.getById(id);
    }

    @PutMapping("/{id}")
    public AuthorBook updateAuthorBook(@PathVariable int id, @RequestBody AuthorBook authorBook) {
        return authorBookService.updateAuthorBook(id, authorBook);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorBook(@PathVariable int id) {
        delete(id);
    }
    @GetMapping("/")
    public List<AuthorBook> getAllAuthorBooks(){
        return authorBookService.getAll();
    }
}
