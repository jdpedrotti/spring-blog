package com.codeup.springblog.controllers;


import com.codeup.springblog.models.RollDiceApp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roll-dice")
public class rollDiceController {

    @GetMapping
    public String dice(){
        return "rollDice";
    }


    @GetMapping("/{num}")
    public String dice(@PathVariable int num, Model model){
        RollDiceApp roll = new RollDiceApp();
        model.addAttribute("roll", roll.randomRoll());
        model.addAttribute("guessedNum", num);

        return "rollDice";
    }




}
