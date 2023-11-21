package com.example.demo.controller;

import com.example.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController<T> {

    @Autowired
    protected BaseService<T, Integer> service;

    protected ResponseEntity<T> create(T entity){
        T createdEntity = service.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
    }

    protected ResponseEntity<Void> delete(int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    protected ResponseEntity<T> getById(int id){
        T createdEntity = service.getById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
    }

}
