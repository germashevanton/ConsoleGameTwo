package com.QATestLab;


public class HeroArcher extends Hero {


    public HeroArcher(Race race, int heroNumber) {
        super(race, heroNumber);
    }

    @Override
    public int attack(Army homeArmy, Army enemies) {
        return 0;
    }


}
