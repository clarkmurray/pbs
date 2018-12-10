package com.clarkamurray.pbs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Attack {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    private String category;

    private Integer power;

    private String effect;

    private Integer pp;

    private Double accuracy;

    private Integer priority;

    private Integer areaRange;

    private Integer typeId;
    @ManyToOne
    @JoinColumn(name = "typeId", referencedColumnName = "id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_type_typeid"))
    private Type type;

    @JsonIgnore
    @ManyToMany(mappedBy = "attacks")
    private List<User_Pokemon> pokemon;

}
