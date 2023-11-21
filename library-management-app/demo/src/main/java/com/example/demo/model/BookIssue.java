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
@Table(name = "bookissue")
public class BookIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookIssueID")
    private int bookIssueID;

    @Column(name = "Date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "librarymember_MemberID")
    private LibraryMember libraryMember;

    @ManyToOne
    @JoinColumn(name = "librarystaff_StaffID")
    private LibraryStaff libraryStaff;

    @ManyToOne
    @JoinColumn(name = "book_ISBN")
    private Book book;

}