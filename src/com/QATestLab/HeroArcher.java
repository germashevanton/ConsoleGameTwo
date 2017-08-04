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
    public int attack(Army homeArmy, Army enemiesArmy) {
        int attackAction = random.nextInt(2);
        switch (getRace()) {
            case PEOPLE:
                if (attackAction == 0) {
                    Main.outputPrintln(getName() + " shot from the crossbow");
                    return 5;
                } else {
                    Main.outputPrintln(getName() + " attack an enemy");
                    return 3;
                }
            case ORC:
                if (attackAction == 0) {
                    Main.outputPrintln(getName() + " shot from the bow");
                    return 3;
                } else {
                    Main.outputPrintln(getName() + " punch by knife");
                    return 2;
                }
            case UNDEAD:
                if (attackAction == 0) {
                    Main.outputPrintln(getName() + " shot from the bow");
                    return 4;
                } else {
                    Main.outputPrintln(getName() + " attack an enemy");
                    return 2;
                }
            case ELF:
                if (attackAction == 0) {
                    Main.outputPrintln(getName() + " shot from the bow");
                    return 7;
                } else {
                    Main.outputPrintln(getName() + " attack an enemy");
                    return 3;
                }

        }
        return 0;

    }


}
