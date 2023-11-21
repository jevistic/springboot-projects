package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Genre;
import com.example.demo.repository.GenreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GenreService extends BaseService<Genre, Integer>{
    @Autowired
    private GenreRepository genreRepository;


    public Genre updateGenre(Integer id, Genre updatedGenre){
        Genre existingGenre = genreRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Genre does not exist with id " + id));

        existingGenre.setGenreID(updatedGenre.getGenreID());
        existingGenre.setGenreName(updatedGenre.getGenreName());
        existingGenre.setDescription(updatedGenre.getDescription());

        return genreRepository.save(existingGenre);
    }
}
