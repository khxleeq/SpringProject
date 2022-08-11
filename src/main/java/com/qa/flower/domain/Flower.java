package com.qa.flower.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String colour;
    private String scent;


    public Flower(Integer id, String name, String colour, String scent) {
        super();
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.scent = scent;
    }
    public Flower(String name, String colour, String scent) {
        super();
        this.name = name;
        this.colour = colour;
        this.scent = scent;
    }

    public Flower() {
        super();
    }



    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getScent() {
        return this.scent;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }

    @Override
    public String toString() {
        return "Flower [name=" + this.name + ", colour=" + this.colour + ", scent=" + this.scent + "]";
    }

}