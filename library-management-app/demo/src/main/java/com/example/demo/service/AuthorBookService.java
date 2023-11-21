package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.AuthorBook;
import com.example.demo.repository.AuthorBookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class AuthorBookService extends BaseService<AuthorBook, Integer> {
    @Autowired
    private AuthorBookRepository authorBookRepository;

    public AuthorBook updateAuthorBook (Integer id, AuthorBook updatedAuthorBook) {
        AuthorBook existingAuthorBook = authorBookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AuthorBook not found with id: " + id));

        existingAuthorBook.setAuthor(updatedAuthorBook.getAuthor());
        existingAuthorBook.setAuthorBookId(updatedAuthorBook.getAuthorBookId());
        existingAuthorBook.setBook(updatedAuthorBook.getBook());

        return authorBookRepository.save(existingAuthorBook);
    }

}
