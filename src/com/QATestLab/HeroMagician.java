package com.QATestLab;

import static com.QATestLab.Race.PEOPLE;


public class HeroMagician extends Hero {


    public HeroMagician(Race race, int heroNumber) {
        super(race, heroNumber);

        switch (race) {
            case PEOPLE:
            case ELF:
                setName(race.toString() + "'s Magician");
                break;
            case ORC:
                setName(race.toString() + "'s Voodoo");
                break;
            case UNDEAD:
                setName(race.toString() + "'s Necromancer");
                break;
        }
    }

    @Override
    public int attack(Army homeArmy, Army enemiesArmy) {
        int attackAction = random.nextInt(2);
        switch (getRace()) {
            case PEOPLE:
                if (attackAction == 0) {
                    Main.outputPrint(getName() + " has made improvements to ");
                    homeArmy.makePrivilege();
                } else {
                    Main.outputPrintln(getName() + " has made damage by magic");
                    return 4;
                }
                break;
            case ORC:
                if (attackAction == 0) {
                    Main.outputPrint(getName() + " has made improvements to ");
                    homeArmy.makePrivilege();
                } else {
                    Main.outputPrint(getName() + " prohibit improvements of the ");
                    enemiesArmy.makeBane();
                }
                break;
            case UNDEAD:
                if (attackAction == 0) {
                    Main.outputPrint(getName() + " has reduced force of the ");
                    enemiesArmy.makeBane();
                } else {
                    Main.outputPrintln(getName() + " has attacked");
                    return 5;
                }
                break;
            case ELF:
                if (attackAction == 0) {
                    Main.outputPrint(getName() + " has made improvements to ");
                    homeArmy.makePrivilege();
                } else {
                    Main.outputPrintln(getName() + " has made damage by magic");
                    return 10;
                }
                break;
        }
        return 0;
    }

}
