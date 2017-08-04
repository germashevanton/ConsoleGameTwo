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
                    int[] arrIndexUsual = homeArmy.usualGroupWhenPrivilege();
                    int index = random.nextInt(arrIndexUsual.length);
                    Main.outputPrintln(homeArmy.listArmy.get(index).getName());
                    homeArmy.makePrivilege(random.nextInt(index));
                } else {
                    Main.outputPrintln(getName() + " has made damage by magic");
                    return 4;
                }
                break;
            case ORC:
                if (attackAction == 0) {
                    Main.outputPrint(getName() + " has made improvements to ");
                    int[] arrIndexUsual = homeArmy.usualGroupWhenPrivilege();
                    int index = random.nextInt(arrIndexUsual.length);
                    Main.outputPrintln(homeArmy.listArmy.get(index).getName());
                    homeArmy.makePrivilege(random.nextInt(index));
                } else {
                    Main.outputPrint(getName() + " prohibit improvements at the next step of ");
                    int[] arrIndexUsual = enemiesArmy.usualGroupWhenBane();
                    int index = random.nextInt(arrIndexUsual.length);
                    Main.outputPrintln(enemiesArmy.listArmy.get(index).getName());
                    enemiesArmy.makeBane(random.nextInt(index));
                }
                break;
            case UNDEAD:
                if (attackAction == 0) {
                    Main.outputPrint(getName() + " has reduced force of the ");
                    int[] arrIndexUsual = enemiesArmy.usualGroupWhenBane();
                    int index = random.nextInt(arrIndexUsual.length);
                    Main.outputPrintln(enemiesArmy.listArmy.get(index).getName() + " at next attack");
                    enemiesArmy.makeBane(random.nextInt(index));
                } else {
                    Main.outputPrintln(getName() + " has attacked");
                    return 5;
                }
                break;
            case ELF:
                if (attackAction == 0) {
                    Main.outputPrint(getName() + " has made improvements to ");
                    int[] arrIndexUsual = homeArmy.usualGroupWhenPrivilege();
                    int index = random.nextInt(arrIndexUsual.length);
                    Main.outputPrintln(homeArmy.listArmy.get(index).getName());
                    homeArmy.makePrivilege(random.nextInt(index));
                } else {
                    Main.outputPrintln(getName() + " has made damage by magic");
                    return 10;
                }
                break;
        }
        return 0;
    }

}
