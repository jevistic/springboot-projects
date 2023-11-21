package com.example.demo.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class BaseService<T, ID> {
    @Autowired
    protected JpaRepository<T, ID> repository;


    public List<T> getAll(){
        return repository.findAll();
    }

    public T create(T entity){
       return repository.save(entity);
    }

    public void delete(ID id){
        Optional<T> optionalEntity = repository.findById(id);
        if(optionalEntity.isPresent()){
            repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Entity not found with ID: " + id);
        }

    }

    public T getById(ID id) {
        Optional<T> optionalEntity = repository.findById(id);
        return optionalEntity.orElseThrow(() -> new EntityNotFoundException("Entity not found with ID: " + id));
    }

}
