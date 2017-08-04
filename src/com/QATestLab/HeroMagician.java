package com.QATestLab;

import static com.QATestLab.Race.PEOPLE;


public class HeroMagician extends Hero {


    public HeroMagician(Race race, int heroNumber) {
        super(race, heroNumber);

        switch (race){
            case PEOPLE: case ELF:
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
        switch (getRace()){
            case PEOPLE:
                if (attackAction == 0){
                    Main.outputPrint(getName() + " has made improvements to ");
                    if (homeArmy.countPrivilege() == 0) {
                        int numInList = random.nextInt(homeArmy.countAliveHeroes());

                    }



                } else {

                }
                break;
            case ORC:
                if (attackAction == 0){

                } else {

                }
                break;
            case UNDEAD:
                if (attackAction == 0){

                } else {

                }
                break;
            case ELF:
                if (attackAction == 0){

                } else {

                }
                break;
        }
        return 0;
    }
}
