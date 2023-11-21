package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.Catalog;
import com.example.demo.model.Genre;
import com.example.demo.service.GenreService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController extends BaseController<Genre>{

    @Autowired
    private GenreService genreService;

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable Integer id){
        return genreService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGenreById(@PathVariable Integer id){
        delete(id);
    }

    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre){
        return create(genre);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable Integer id, @RequestBody Genre genre){
        return genreService.updateGenre(id, genre);
    }

    @GetMapping("/")
    public List<Genre> getAllCatalogs(){
        return genreService.getAll();
    }
}
