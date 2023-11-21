package com.example.demo.controller;
import com.example.demo.model.Book;
import com.example.demo.model.Catalog;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
public class CatalogController extends BaseController<Catalog> {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/{id}")
    public Catalog getCatalogById(@PathVariable Integer id){
        return catalogService.getById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Catalog> createCatalog(@RequestBody Catalog catalog){
        return create(catalog);
    }

    @DeleteMapping("/{id}")
    public void deleteCatalog(@PathVariable Integer id){
        delete(id);
    }

    @PutMapping("/{id}")
    public Catalog updateCatalog(@PathVariable Integer id, @RequestBody Catalog catalog){
        return catalogService.updateCatalog(id, catalog);
    }

    @GetMapping("/")
    public List<Catalog> getAllCatalogs(){
        return catalogService.getAll();
    }
}
