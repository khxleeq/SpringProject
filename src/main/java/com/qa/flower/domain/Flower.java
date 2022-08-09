package com.qa.flower.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;

    private String name;
    private String colour;
    private String scent;

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
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getScent() {
        return scent;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }
}