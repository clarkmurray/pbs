package com.clarkamurray.pbs.controller;

import com.clarkamurray.pbs.config.AbstractController;
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
@RequestMapping("/api/user")
public class UserController extends AbstractController<User, Long> {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

}
