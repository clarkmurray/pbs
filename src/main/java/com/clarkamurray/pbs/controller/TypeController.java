package com.clarkamurray.pbs.controller;

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
@RequestMapping("/type")
public class TypeController {

    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> findAllTypes(HttpServletRequest request) {
        List<Type> results = typeService.findAllTypes();
        return ResponseEntity.ok(results);
    }
}
