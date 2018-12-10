package com.clarkamurray.pbs.controller;

import com.clarkamurray.pbs.config.AbstractController;
import com.clarkamurray.pbs.service.PokemonService;
import com.clarkamurray.pbs.repository.User_PokemonRepository;
import com.clarkamurray.pbs.model.Pokemon;
import com.clarkamurray.pbs.model.User_Pokemon;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController extends AbstractController<Pokemon, Integer> {

    private PokemonService pokemonService;
    private User_PokemonRepository userPokemonRepository;

    public PokemonController(PokemonService pokemonService,
                             User_PokemonRepository userPokemonRepository) {
        super(pokemonService);
        this.pokemonService = pokemonService;
        this.userPokemonRepository = userPokemonRepository;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllPokemon(HttpServletRequest request) {
        List<Pokemon> results = pokemonService.getAllPokemon();
        return ResponseEntity.ok(results);
    }

    @GetMapping(value = "/json/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllJsonPokemon(HttpServletRequest request) {
        List<Pokemon> results = pokemonService.getAllJsonPokemon();
        return ResponseEntity.ok(results);
    }

    @GetMapping(value = "/json/single/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPokemon(@PathVariable String name, HttpServletRequest request) {
        Pokemon pokemon = pokemonService.getJsonPokemon(name);
        return ResponseEntity.ok(pokemon);
    }

    @GetMapping(value = "user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserPokemon(@PathVariable Long userId, HttpServletRequest request) {
        List<Pokemon> results = new ArrayList<>();
        List<User_Pokemon> userPokemon = userPokemonRepository.findByUserId(userId);
        for (User_Pokemon up : userPokemon) {
            Pokemon pokemon = new Pokemon();

            // Load Pokemon from file by id

            results.add(pokemon);
        }
        return ResponseEntity.ok(results);
    }

}
