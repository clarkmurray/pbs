package com.clarkamurray.pbs.controller;

import com.clarkamurray.pbs.config.AbstractController;
import com.clarkamurray.pbs.model.User_Pokemon;
import com.clarkamurray.pbs.service.User_PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/user-pokemon")
public class User_PokemonController extends AbstractController<User_Pokemon, Long> {

    private User_PokemonService userPokemonService;

    @Autowired
    public User_PokemonController(User_PokemonService userPokemonService) {
        super(userPokemonService);
        this.userPokemonService = userPokemonService;
    }

//    @GetMapping(value = "/{userId}/all")
//    public ResponseEntity<?> findUserPokemon(@PathVariable(name = "userId") Long userId, HttpServletRequest request) {
//        List<User_Pokemon> results = userPokemonService.findUserPokemon(userId);
//        return ResponseEntity.ok(results);
//    }

}
