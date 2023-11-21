package com.example.demo.service;

import com.example.demo.model.AuthorBook;
import com.example.demo.model.BookIssue;
import com.example.demo.repository.BookIssueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookIssueService extends BaseService<BookIssue, Integer> {
    @Autowired
    private BookIssueRepository bookIssueRepository;

    public BookIssue updateBookIssue (Integer id, BookIssue updatedBookIssue) {
        BookIssue existingBookIssue = bookIssueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AuthorBook not found with id: " + id));

        existingBookIssue.setBook(updatedBookIssue.getBook());
        existingBookIssue.setBookIssueID(updatedBookIssue.getBookIssueID());
        existingBookIssue.setDate(updatedBookIssue.getDate());
        existingBookIssue.setLibraryMember(updatedBookIssue.getLibraryMember());
        existingBookIssue.setLibraryStaff(updatedBookIssue.getLibraryStaff());

        return bookIssueRepository.save(existingBookIssue);
    }

}
