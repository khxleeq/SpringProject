package com.qa.cats.rest;


import com.qa.cats.domain.Cat;
import org.springframework.web.bind.annotation.*;
import com.qa.cats.domain.Cat;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CatController {

    private List<Cat> cats;



    @GetMapping("/hello")
    public String greeting() {
        return "Hello, world!";
    }

    @PostMapping("/createCat")
    public void makeCat(@RequestBody Cat cat) {
        System.out.println("Body: " + cat);
    }

    @GetMapping("/getAll")
    public List<Cat> getAllCats() {
        return this.cats;
    }

    @GetMapping("/get/{id}")
    public Cat getById(@PathVariable int id) {
        System.out.println("ID: " + id);
        return this.cats.get(id);
    }

    @PatchMapping("/update/{id}")
    public void updateBiscuit(@PathVariable int id, @PathParam("name") String name, @PathParam("amount") Integer amount,
                              @PathParam("cost") Double cost) {
        System.out.println("ID: " + id);
        System.out.println("NAME: " + name);
        System.out.println("AMOUNT: " + amount);
        System.out.println("COST: " + cost);
    }

    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable int id) {
        System.out.println("ID: " + id);
    }

}