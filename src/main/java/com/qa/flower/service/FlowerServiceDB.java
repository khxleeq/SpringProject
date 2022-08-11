package com.qa.flower.service;


import com.qa.flower.domain.Flower;
import com.qa.flower.repos.FlowerRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class FlowerServiceDB  implements  FlowerService {

    private FlowerRepo repo;

    public FlowerServiceDB(FlowerRepo repo) {
        super();
        this.repo = repo;
    }


    @Override
    public Flower makeFlower(Flower flower) {
        return this.repo.save(flower);
    }

    @Override
    public List<Flower> getAllFlowers() {
        return this.repo.findAll();
    }

    @Override
    public Flower getById(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public Flower updateFlower(int id, String name, String colour, String scent) {
        Flower toUpdate = this.repo.findById(id).get(); // fetches the existing data from the db

        if (name != null && !name.isBlank())
            toUpdate.setName(name);
        if (colour != null)
            toUpdate.setColour(colour);
        if (scent != null)
            toUpdate.setScent(scent);

        return this.repo.save(toUpdate); // saves the new data and returns it

    }

    @Override
    public void delete(int id) {
        this.repo.deleteById(id);
    }
}
