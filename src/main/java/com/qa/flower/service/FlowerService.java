package com.qa.flower.service;

import com.qa.flower.domain.Flower;

import java.util.List;

public interface FlowerService {

    Flower makeFlower(Flower flower);

    List<Flower> getAllFlowers();

    Flower getById(int id);

    Flower updateFlower(int id, String name, String colour, String scent);
    void delete(int id);
}
