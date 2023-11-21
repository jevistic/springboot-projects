package com.example.demo.service;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

@Service
@Transactional
public class AuthorService extends BaseService<Author, Integer>{

    @Autowired
    private AuthorRepository authorRepository;

    public Author updateAuthor(Integer id, Author updatedAuthor) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        existingAuthor.setAuthorName(updatedAuthor.getAuthorName());
        existingAuthor.setBiography(updatedAuthor.getBiography());
        existingAuthor.setNationality(updatedAuthor.getNationality());
        existingAuthor.setDateOfBirth(updatedAuthor.getDateOfBirth());

        return authorRepository.save(existingAuthor);
    }

}