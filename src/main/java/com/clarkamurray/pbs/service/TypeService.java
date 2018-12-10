package com.clarkamurray.pbs.service;

import com.clarkamurray.pbs.model.Type;
import com.clarkamurray.pbs.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> findAllTypes() {
        List<Type> types = typeRepository.findAll();
        return types;
    }
}
