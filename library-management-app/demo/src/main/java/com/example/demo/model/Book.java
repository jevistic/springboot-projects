package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ISBN")
    private int isbn;

    @Column(name = "Title", length = 50)
    private String title;

    @Column(name = "PublicationDate")
    private Date publicationDate;

    @Column(name = "Language", length = 30)
    private String language;

    @Column(name = "NumOfPages")
    private int numOfPages;

    @Column(name = "Price")
    private float price;

    @ManyToOne(targetEntity = Catalog.class, cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false, name = "catalogid")
    private Catalog catalog;
}
