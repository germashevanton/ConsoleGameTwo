package com.QATestLab;


public class HeroArcher extends Hero {


    public HeroArcher(Race race, int heroNumber) {
        super(race, heroNumber);

        switch (race) {
            case PEOPLE:
                setName(race.toString() + "'s Crossbowman #" + heroNumber);
            case ELF:
                setName(race.toString() + "'s Archer #" + heroNumber);
                break;
            case ORC:
                setName(race.toString() + "'s Archer #" + heroNumber);
                break;
            case UNDEAD:
                setName(race.toString() + "'s Hunter #" + heroNumber);
                break;
        }
    }

    @Override
    public void attack(Army homeArmy, Army enemiesArmy) {
        int attackAction = random.nextInt(2);
        double damage = 0;
        switch (getRace()) {

            case PEOPLE:
                if (attackAction == 0) {
                    Main.outputPrintln(getName() + " shot from the crossbow");
                    damage = 5;
                } else {
                    Main.outputPrintln(getName() + " attack an enemy");
                    damage = 3;
                }
            case ORC:
                if (attackAction == 0) {
                    Main.outputPrintln(getName() + " shot from the bow");
                    damage = 3;
                } else {
                    Main.outputPrintln(getName() + " punch by knife");
                    damage = 2;
                }
            case UNDEAD:
                if (attackAction == 0) {
                    Main.outputPrintln(getName() + " shot from the bow");
                    damage = 4;
                } else {
                    Main.outputPrintln(getName() + " attack an enemy");
                    damage = 2;
                }
            case ELF:
                if (attackAction == 0) {
                    Main.outputPrintln(getName() + " shot from the bow");
                    damage = 7;
                } else {
                    Main.outputPrintln(getName() + " attack an enemy");
                    damage = 3;
                }

        }
        enemiesArmy.attackHero(damage, this);
    }
}
