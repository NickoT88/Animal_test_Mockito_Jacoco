package com.example;

import java.util.List;

public class AlexLion extends Lion {


    public AlexLion(Feline feline) throws Exception { //другой конструктор для льва Алекса
        super("Самец", feline);
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        return List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

}