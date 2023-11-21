package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.model.BookGenre;
import com.example.demo.model.BookIssue;
import com.example.demo.service.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookissue")
public class BookIssueController extends BaseController<BookIssue>{
    @Autowired
    private BookIssueService bookIssueService;

    @PostMapping("/")
    public ResponseEntity<BookIssue> createBookIssue(@RequestBody BookIssue bookIssue) {
        return create(bookIssue);
    }


    @GetMapping("/{id}")
    public BookIssue getBookIssueById(@PathVariable int id) {
        return bookIssueService.getById(id);
    }

    @PutMapping("/{id}")
    public BookIssue updateBookIssue(@PathVariable int id, @RequestBody BookIssue bookIssue) {
        return bookIssueService.updateBookIssue(id, bookIssue);
    }

    @DeleteMapping("/{id}")
    public void deleteBookIssue(@PathVariable int id) {
        delete(id);
    }

    @GetMapping("/")
    public List<BookIssue> getAllBookIssues(){
        return bookIssueService.getAll();
    }

}
