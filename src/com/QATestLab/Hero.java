package com.QATestLab;

import java.util.Random;


public abstract class Hero {
    private Race race;
    private String name;
    private int heroNumber;
    private double liveLevelHP = 100;
    private boolean privilege = false;
    private boolean bane = false;
    public Random random = new Random();


    public Hero(Race race, int heroNumber){
        this.race = race;
        this.heroNumber = heroNumber;
    }

    public Race getRace() {
        return race;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHeroNumber() {
        return heroNumber;
    }

    public double getLiveLevelHP() {
        return liveLevelHP;
    }


    public boolean isPrivilege() {
        return privilege;
    }

    public void setPrivilege(boolean privilege) {
        this.privilege = privilege;
    }

    public boolean isBane() {
        return bane;
    }

    public void setBane(boolean bane) {
        this.bane = bane;
    }

    public boolean damage(int attackValue, Army army){
        if ((this.liveLevelHP -= attackValue) > 0){
            return false; // hero alive
        } else {
            army.listArmy.remove(this);
            Main.outputPrintln(getName() + " is killed");
            return true; // hero killed
        }

    }

    public abstract int attack(Army homeArmy, Army enemies);






}
