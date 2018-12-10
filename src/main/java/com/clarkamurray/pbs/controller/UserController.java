package com.clarkamurray.pbs.controller;

import com.clarkamurray.pbs.service.UserService;
import com.clarkamurray.pbs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

}
