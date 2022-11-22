package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.models.Supplier;
import com.codeup.springblog.repositories.CoffeeRepository;
import com.codeup.springblog.repositories.SupplierRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    private final CoffeeRepository coffeeDao;
    private final SupplierRepository supplierDao;

    public CoffeeController(CoffeeRepository coffeeDao, SupplierRepository supplierDao) {
        this.coffeeDao = coffeeDao;
        this.supplierDao = supplierDao;
    }


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





    @PostMapping
    public String signUp(@RequestParam(name = "email") String email, Model model){
        model.addAttribute("email", email);
        return "coffee";
    }

    @GetMapping("/suppliers")
    public String showSuppliersForm(Model model){
        List<Supplier> suppliers = supplierDao.findAll();
        model.addAttribute("suppliers", suppliers);
        return "/suppliers";
    }

    @PostMapping("/suppliers")
    public String insertSupplier(@RequestParam(name = "name") String name){
        Supplier supplier = new Supplier(name);
        supplierDao.save(new Supplier(name));
        return "redirect:/coffee/suppliers";
    }

}
