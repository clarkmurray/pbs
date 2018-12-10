package com.clarkamurray.pbs.repository;

import com.clarkamurray.pbs.model.User_Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_PokemonRepository extends JpaRepository<User_Pokemon, Long>, JpaSpecificationExecutor<User_Pokemon> {

    List<User_Pokemon> findByUserId(Long userId);

}
