package com.clarkamurray.pbs.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Pokemon {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    private String entry;

    private String classification;

    private String description;

    private Integer hp;

    private Integer attack;

    private Integer defense;

    private Integer special;

    private Integer specialAttack;

    private Integer specialDefense;

    private Integer speed;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "pokemon_types",
            joinColumns = @JoinColumn(name = "pokemon_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_pokemon_types_pokemonid")),
            inverseJoinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_pokemon_types_typeid")))
    private List<Type> types;

}
