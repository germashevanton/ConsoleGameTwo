package com.QATestLab;


public class HeroWarrior extends Hero{
    public HeroWarrior(Race race, int heroNumber) {

        super(race, heroNumber);

        switch (race) {
            case PEOPLE:
                setName(race.toString() + "'s Warrior #" + heroNumber);
            case ELF:
                setName(race.toString() + "'s Warrior #" + heroNumber);
                break;
            case ORC:
                setName(race.toString() + "'s Warrior #" + heroNumber);
                break;
            case UNDEAD:
                setName(race.toString() + "'s Zombie #" + heroNumber);
                break;
        }
    }

    @Override
    public void attack(Army homeArmy, Army enemiesArmy) {
        double damage = 0;
        switch (getRace()) {
            case PEOPLE:
                Main.outputPrintln(getName() + " has attacked by sword");
                damage = 18;
            case ORC:
                Main.outputPrintln(getName() + " has attacked by truncheon");
                damage = 20;
            case UNDEAD:
                Main.outputPrintln(getName() + " has attacked by spear");
                damage = 18;
            case ELF:
                Main.outputPrintln(getName() + " has attacked by sword");
                damage = 15;
        }
        enemiesArmy.attackHero(damage, this);
    }
}
