package com.clarkamurray.pbs.service;

import com.clarkamurray.pbs.config.AbstractTableService;
import com.clarkamurray.pbs.model.User_Pokemon;
import com.clarkamurray.pbs.repository.User_PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_PokemonService extends AbstractTableService<User_Pokemon, Long> {

    private User_PokemonRepository userPokemonRepository;

    @Autowired
    public User_PokemonService(User_PokemonRepository userPokemonRepository) {
        super(userPokemonRepository);
        this.userPokemonRepository = userPokemonRepository;
    }

    public List<User_Pokemon> findUserPokemon(Long userId) {
        List<User_Pokemon> userPokemon = userPokemonRepository.findByUserId(userId);
        return userPokemon;
    }
}
