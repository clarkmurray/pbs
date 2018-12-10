package com.clarkamurray.pbs.config;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractController<T, ID extends Serializable>{

    AbstractTableService<T, ID> service;

    public AbstractController(AbstractTableService<T, ID> service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        List<T> results = service.findAll();
        if(results == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(results);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable ID id, HttpServletRequest request) {
        Optional<T> result = service.findById(id);
        if(result == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(result);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody T object, HttpServletRequest request) {
        T result = service.save(object);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody T object, HttpServletRequest request) {
        T result = service.save(object);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id, HttpServletRequest request) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}