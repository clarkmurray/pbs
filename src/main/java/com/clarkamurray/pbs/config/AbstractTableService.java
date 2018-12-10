package com.clarkamurray.pbs.config;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.Optional;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public abstract class AbstractTableService<T, ID extends Serializable> {

    private JpaRepository<T, ID> repository;
    private JpaSpecificationExecutor<T> specificationExecutor;

    @SuppressWarnings (value="unchecked")
    public AbstractTableService(JpaRepository<T, ID> repository) {
        this.repository = repository;
        this.specificationExecutor = (JpaSpecificationExecutor<T>)repository;
    }

    public T save(T object){
        T result = repository.save(object);
        return result;
    }

    public List<T> saveAll(List<T> list) {
        List<T> results = repository.saveAll(list);
        return results;
    }

    public void deleteById(ID key){
        repository.deleteById(key);
    }

    public void deleteInBatch(List<T> list){
        repository.deleteInBatch(list);
    }

    public Optional<T> findById(ID id){
        Optional<T> result = repository.findById(id);
        return result;
    }

    public List<T> findAll(){
        List<T> results = repository.findAll();
        return results;
    }

    public List<T> findAll(Specification<T> spec) {
        List<T> results = specificationExecutor.findAll(spec);
        return results;
    }

    public List<T> findAll(Specification<T> spec, Sort sort) {
        List<T> results = specificationExecutor.findAll(spec, sort);
        return results;
    }

    public List<T> findAll(Specification<T> spec, Pageable pageable) {
        List<T> results = specificationExecutor.findAll(spec, pageable).getContent();
        return results;
    }

    public List<T> findAll(Example<T> example) {
        List<T> results = repository.findAll(example);
        return results;
    }

    public List<T> findAll(Example<T> example, Pageable pageable) {
        List<T> results = repository.findAll(example, pageable).getContent();
        return results;
    }

    public List<T> findAll(Sort sort) {
        List<T> results = repository.findAll(sort);
        return results;
    }

    public List<T> findAll(Pageable pageable) {
        List<T> results = repository.findAll(pageable).getContent();
        return results;
    }

    public Boolean compare(BigDecimal left, String operator, BigDecimal right) {
        Boolean result = Boolean.FALSE;
        int compare = left.compareTo(right);
        switch (operator){
            case "=":
                result = compare == 0;
                break;
            case ">":
                result = compare > 0;
                break;
            case "<":
                result = compare < 0;
                break;
            case ">=":
                result = compare >= 0;
                break;
            case "<=":
                result = compare <= 0;
                break;
        }
        return result;
    }

}
