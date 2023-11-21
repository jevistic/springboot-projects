package com.example.demo.controller;

import com.example.demo.model.AuthorBook;
import com.example.demo.model.Book;
import com.example.demo.model.BookGenre;
import com.example.demo.service.BaseService;
import com.example.demo.service.BookGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookgenre")
public class BookGenreController extends BaseController<BookGenre>{
    @Autowired
    private BookGenreService bookGenreService;

    @PostMapping("/")
    public ResponseEntity<BookGenre> createBookGenre(@RequestBody BookGenre bookGenre) {
        return create(bookGenre);
    }


    @GetMapping("/{id}")
    public BookGenre getBookGenreById(@PathVariable int id) {
        return bookGenreService.getById(id);
    }

    @PutMapping("/{id}")
    public BookGenre updateBookGenre(@PathVariable int id, @RequestBody BookGenre bookGenre) {
        return bookGenreService.updateBookGenre(id, bookGenre);
    }

    @DeleteMapping("/{id}")
    public void deleteBookGenre(@PathVariable int id) {
        delete(id);
    }
    @GetMapping("/")
    public List<BookGenre> getAllBookGenres(){
        return bookGenreService.getAll();
    }

}
