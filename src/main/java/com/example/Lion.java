package com.example;

import java.util.List;

public class Lion extends Animal{

    boolean hasMane;
    Predator predator;



    public Lion(String sex,Predator predator) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
            this.predator = predator;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
            this.predator = predator;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }


    public int getKittens() {
        return predator.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return getFood("Хищник");
    }



}
