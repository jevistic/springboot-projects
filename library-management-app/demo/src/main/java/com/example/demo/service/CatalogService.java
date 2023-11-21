package com.example.demo.service;
import com.example.demo.model.Author;
import com.example.demo.model.Catalog;
import com.example.demo.repository.CatalogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CatalogService extends BaseService<Catalog, Integer>{

    @Autowired
    private CatalogRepository catalogRepository;


    public Catalog updateCatalog(Integer id, Catalog catalog){
        Catalog existingCatalog = catalogRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Catalog does not exist with id "+ id));

        existingCatalog.setCatalogName(catalog.getCatalogName());

        return catalogRepository.save(existingCatalog);
    }

}
