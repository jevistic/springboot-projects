package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bookgenre")
public class BookGenre {
    @Id
    @Column(name = "BookGenreID")
    private int bookGenreID;

    @ManyToOne
    @JoinColumn(name = "genre_GenreID")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "book_ISBN")
    private Book book;

}