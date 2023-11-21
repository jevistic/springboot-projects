package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuthorID")
    private int id;

    @Column(name = "AuthorName", length = 100)
    private String authorName;

    @Column(name = "Biography", columnDefinition = "text")
    private String biography;

    @Column(name = "Nationality", length = 50)
    private String nationality;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

}
