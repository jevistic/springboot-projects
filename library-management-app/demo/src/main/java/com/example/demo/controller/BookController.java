package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController extends BaseController<Book>{

    @Autowired
    private BookService bookService;

    @PostMapping("/")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return create(book);
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Integer id){
        delete(id);
    }


    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book){
        return bookService.updateBook(book, id);
    }

    @GetMapping("/")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

}
