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
@Table(name = "librarystaff")
public class LibraryStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StaffID")
    private int staffID;

    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "Role", length = 20)
    private String role;

    @Column(name = "Phone", length = 15)
    private String phone;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "Username", length = 20)
    private String username;

    @Column(name = "Password", length = 100)
    private String password;

}