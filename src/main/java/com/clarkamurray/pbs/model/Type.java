package com.clarkamurray.pbs.model;

import com.clarkamurray.pbs.model.Pokemon;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Type {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "types")
    private List<Pokemon> pokemon;

}
