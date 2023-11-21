package com.example.demo.service;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Catalog;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CatalogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BookService extends BaseService<Book, Integer>{


    @Autowired
    private  BookRepository bookRepository;
    @Autowired
    private CatalogRepository catalogRepository;

    public Book createBook(Book book) {

        // Retrieve the associated Catalog based on catalogID
        int catId = book.getCatalog().getCatalogID();
        if ((book.getCatalog() != null) && (catId > 0)) {
            Catalog catalog = catalogRepository.findById(catId)
                    .orElse(null);

            if (catalog != null) {
                // Set the catalogName in the Book entity
                book.getCatalog().setCatalogName(catalog.getCatalogName());
            }
        }

        // Save the Book entity
        return bookRepository.save(book);
    }

    public Book updateBook(Book updatedBook, Integer id){
        Book exisitingBook = bookRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Book not found with id " + id));

        exisitingBook.setTitle(updatedBook.getTitle());
        exisitingBook.setCatalog(updatedBook.getCatalog());
        exisitingBook.setLanguage(updatedBook.getLanguage());
        exisitingBook.setPrice(updatedBook.getPrice());
        exisitingBook.setNumOfPages(updatedBook.getNumOfPages());
        exisitingBook.setPublicationDate(updatedBook.getPublicationDate());

        return bookRepository.save(exisitingBook);
    }

}
