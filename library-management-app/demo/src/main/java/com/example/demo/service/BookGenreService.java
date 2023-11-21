package com.example.demo.service;

import com.example.demo.model.AuthorBook;
import com.example.demo.model.BookGenre;
import com.example.demo.repository.BookGenreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookGenreService extends BaseService<BookGenre, Integer> {
    @Autowired
    private BookGenreRepository bookGenreRepository;

    public BookGenre updateBookGenre (Integer id, BookGenre updatedbookGenre) {
        BookGenre existingBookGenre = bookGenreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AuthorBook not found with id: " + id));

        existingBookGenre.setBook(updatedbookGenre.getBook());
        existingBookGenre.setBookGenreID(updatedbookGenre.getBookGenreID());
        existingBookGenre.setGenre(updatedbookGenre.getGenre());

        return bookGenreRepository.save(existingBookGenre);
    }

}
