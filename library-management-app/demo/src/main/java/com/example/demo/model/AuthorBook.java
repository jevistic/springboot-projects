package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "authorbook")
public class AuthorBook {
    @Id
    @Column(name = "AuthorBookId")
    private int authorBookId;

    @ManyToOne
    @JoinColumn(name = "author_AuthorID")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_ISBN")
    private Book book;

}
