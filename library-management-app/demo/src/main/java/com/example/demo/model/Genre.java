package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GenreID")
    private int genreID;

    @Column(name = "GenreName", length = 30)
    private String genreName;

    @Column(name = "Description", length = 80)
    private String description;

}