package com.clarkamurray.pbs;

import lombok.Data;

@Data
public class Attack {

    private String type;

    private String category;

    private int power;

    private String effect;

    private int pp;

    private double accuracy;

    private int priority;

    private int range;
}
