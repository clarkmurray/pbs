package com.clarkamurray.pbs.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User_Pokemon {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Long userId;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_user_userid"))
    private User user;

    private Integer pokemonId;
    @ManyToOne
    @JoinColumn(name = "pokemonId", referencedColumnName = "id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_pokemon_pokemonid"))
    private Pokemon pokemon;

    private String nickname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_pokemon_attacks",
            joinColumns = @JoinColumn(name = "user_pokemon_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_user_pokemon_attacks_userpokemonid")),
            inverseJoinColumns = @JoinColumn(name = "attack_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_user_pokemon_attacks_attackid")))
    private List<Attack> attacks;

}
