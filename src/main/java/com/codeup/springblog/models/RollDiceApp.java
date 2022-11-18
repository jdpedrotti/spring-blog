package com.codeup.springblog.models;

public class RollDiceApp {

    final int sides =6;

    public int randomRoll(){
        return (int) Math.floor(Math.random() * sides) + 1;
    }

    public RollDiceApp(){
    }

}
