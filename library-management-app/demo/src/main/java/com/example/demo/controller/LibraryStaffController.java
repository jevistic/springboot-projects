package com.example.demo.controller;

import com.example.demo.model.LibraryMember;
import com.example.demo.model.LibraryStaff;
import com.example.demo.service.LibraryStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class LibraryStaffController extends BaseController<LibraryStaff> {

    @Autowired
    private LibraryStaffService libraryStaffService;

    @GetMapping("/{id}")
    public LibraryStaff getLibraryStaffById(@PathVariable Integer id){
        return libraryStaffService.getById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteLibraryStaffById(@PathVariable Integer id){
        delete(id);
    }

    @PostMapping("/")
    public ResponseEntity<LibraryStaff> createLibraryStaff(@RequestBody LibraryStaff libraryStaff){
        return create(libraryStaff);
    }

    @PutMapping("/{id}")
    public LibraryStaff updateLibraryStaff(@PathVariable Integer id, @RequestBody LibraryStaff libraryStaff){
        return libraryStaffService.updateLibraryStaff(id, libraryStaff);
    }

    @GetMapping("/")
    public List<LibraryStaff> getAllCatalogs(){
        return libraryStaffService.getAll();
    }

}

