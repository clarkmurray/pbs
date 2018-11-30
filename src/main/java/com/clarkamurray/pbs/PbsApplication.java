package com.clarkamurray.pbs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class PbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbsApplication.class, args);
		getPokemon();
	}

	public static void getPokemon() {
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
			ArrayList<Pokemon> pokemon = objectMapper.readValue(jsonString, typeFactory.constructCollectionType(List.class, Pokemon.class));
			for (Pokemon pkmn : pokemon) {
				System.out.println(pkmn.getName() + ", the " + pkmn.getClassification());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
