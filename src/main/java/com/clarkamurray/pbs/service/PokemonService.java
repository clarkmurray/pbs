package com.clarkamurray.pbs.service;

import com.clarkamurray.pbs.config.AbstractTableService;
import com.clarkamurray.pbs.model.Pokemon;
import com.clarkamurray.pbs.repository.PokemonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService extends AbstractTableService<Pokemon, Integer> {

    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        super(pokemonRepository);
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemon() {
        List<Pokemon> pokemon = pokemonRepository.findAll();
        return pokemon;
    }

    public List<Pokemon> getAllJsonPokemon() {
        ArrayList<Pokemon> pokemon = new ArrayList<>();
        String jsonString = "";
        try {
            Resource resource = new ClassPathResource("pokemon.json");
            FileReader fr = new FileReader(resource.getFile());
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            jsonString = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        try {
            pokemon = objectMapper.readValue(jsonString, typeFactory.constructCollectionType(List.class, Pokemon.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pokemon;
    }

    public Pokemon getJsonPokemon(String name) {
        List<Pokemon> pokemon = getAllJsonPokemon();
        name= name.toUpperCase().charAt(0) + name.substring(1, name.length());
        for (Pokemon p : pokemon) {
            if (p.getName().equals(name)) {
                return p;
            }
        }

        return null;
    }

}
