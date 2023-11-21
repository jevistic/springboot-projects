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
@Table(name = "librarymember")
public class LibraryMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MemberID")
    private int memberID;

    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "Address", length = 100)
    private String address;

    @Column(name = "Phone", length = 15)
    private String phone;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "MembershipType", length = 20)
    private String membershipType;

    @Column(name = "RegistrationDate")
    private Date registrationDate;
}