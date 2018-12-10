package com.clarkamurray.pbs.controller;

import com.clarkamurray.pbs.config.AbstractController;
import com.clarkamurray.pbs.model.Type;
import com.clarkamurray.pbs.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/type")
public class TypeController extends AbstractController<Type, Integer> {

    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        super(typeService);
        this.typeService = typeService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> findAllTypes(HttpServletRequest request) {
        List<Type> results = typeService.findAllTypes();
        return ResponseEntity.ok(results);
    }
}
