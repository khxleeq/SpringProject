package com.qa.flower.rest;

import com.qa.flower.domain.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.qa.flower.service.FlowerService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class FlowerController {

    private FlowerService service;

    @Autowired
    public FlowerController(FlowerService service) {
        super();
        this.service = service;
    }

    @GetMapping("/hello")
    public String greeting() {
        return "Hello, world!";
    }

    @PostMapping("/createFlower")
    public ResponseEntity<Flower> makeFlower(@RequestBody Flower flower) {
        System.out.println("Body: " + flower);
        return new ResponseEntity<Flower>(this.service.makeFlower(flower), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAll")
    public List<Flower> getAllFlowers() {
        return this.service.getAllFlowers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Flower> getById(@PathVariable int id) {
        System.out.println("ID: " + id);
        return new ResponseEntity<Flower>(this.service.getById(id),HttpStatus.I_AM_A_TEAPOT);
    }

    @PatchMapping("/update/{id}")
    public Flower updateFlower(@PathVariable int id, @PathParam("name") String name,
                                 @PathParam("colour") String colour, @PathParam("scent") String scent) {
        System.out.println("ID: " + id);
        System.out.println("NAME: " + name);
        System.out.println("COLOUR: " + colour);
        System.out.println("SCENT: " + scent);

        return this.service.updateFlower(id, name, colour, scent);
    }

    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable int id) {
        System.out.println("ID: " + id);
        this.service.delete(id);
    }

}