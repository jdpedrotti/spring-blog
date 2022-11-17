package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.repositories.CoffeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {

// Dependency Injection
    private final CoffeeRepository coffeeDao;

    public CoffeeController(CoffeeRepository coffeeDao) {
        this.coffeeDao = coffeeDao;
    }
//^^


    @GetMapping
    public String coffee(){
        return "coffee";
    }

    @GetMapping("/{roast}")
    public String roast(@PathVariable String roast, Model model){
        Coffee selection = new Coffee(roast, "Cool Beans");
        Coffee selection2 = new Coffee(roast, "Coffee Bros");
        selection.setOrigin("Ethiopia");
        selection2.setOrigin("Vietnam");
        List<Coffee> selections = new ArrayList<>(List.of(selection, selection2));
        model.addAttribute("selections", selections);
        return "coffee";
    }

    @GetMapping("/all-coffees")
    public String allCoffees(Model model){
        List<Coffee> coffees = coffeeDao.findAll();
        model.addAttribute("coffees", coffees);
        return "all-coffees";
    }


    @GetMapping("/new")
    public String addCoffeeForm(){
        return "create-coffee";
    }

    @PostMapping("/new")
    public String addCoffee(@RequestParam(name ="roast") String roast, @RequestParam(name = "origin") String origin, @RequestParam(name = "brand") String brand){
        Coffee Coffee = new Coffee(roast, origin, brand);
        coffeeDao.save(Coffee);
        return "redirect:/coffee/all-coffees";
    }



    @PostMapping
    public String signUp(@RequestParam(name = "email") String email, Model model){
        model.addAttribute("email", email);
        return "coffee";
    }



}
