package com.example.demo.controller;

import com.example.demo.model.Genre;
import com.example.demo.model.LibraryMember;

import com.example.demo.service.LibraryMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class LibraryMemberController extends BaseController<LibraryMember> {

    @Autowired
    private LibraryMemberService libraryMemberService;

    @GetMapping("/{id}")
    public LibraryMember getLibraryMemberById(@PathVariable Integer id){
        return libraryMemberService.getById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteLibraryMemberById(@PathVariable Integer id){
        delete(id);
    }

    @PostMapping("/")
    public ResponseEntity<LibraryMember> createLibraryMember(@RequestBody LibraryMember libraryMember){
        return create(libraryMember);
    }

    @PutMapping("/{id}")
    public LibraryMember updateLibraryMember(@PathVariable Integer id, @RequestBody LibraryMember libraryMember){
        return libraryMemberService.updateLibraryMember(id, libraryMember);
    }

    @GetMapping("/")
    public List<LibraryMember> getAllCatalogs(){
        return libraryMemberService.getAll();
    }

}
