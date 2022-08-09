package com.qa.flower.service;

import com.qa.flower.domain.Flower;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerServiceList implements FlowerService {

    public List<Flower> flowers;

    public FlowerServiceList() {
        super();
        this.flowers = new ArrayList<>();
        this.flowers.add(new Flower("Rose", "Red", "Sweet"));
    }

    @Override
    public Flower makeFlower(Flower flower) {
        this.flowers.add(flower);
        return flowers.get(this.flowers.size() -1);
    }

    @Override
    public List<Flower> getAllFlowers() {
        return this.flowers;
    }

    @Override
    public Flower getById(int id) {
        return this.flowers.get(id);
    }

    @Override
    public Flower updateFlower(int id, String name, String colour, String scent) {
        Flower toUpdate = this.flowers.get(id);

        if (name != null && !name.isBlank())
            toUpdate.setName(name);
        if (colour != null)
            toUpdate.setColour(colour);
        if (scent != null)
            toUpdate.setScent(scent);

        return toUpdate;

    }

    @Override
    public void delete(int id) {
        this.flowers.remove(id);

    }
}
