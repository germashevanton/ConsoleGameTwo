package com.QATestLab;


public class HeroWarrior extends Hero{

    public HeroWarrior(Race race, int heroNumber) {
        super(race, heroNumber);
    }

    @Override
    public int attack() {
        return 0;
    }
}
