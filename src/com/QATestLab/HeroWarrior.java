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
                Main.outputPrint(getName() + " (" + getLiveLevelHP() + " HP) has attacked by sword ");
                damage = 18;
                break;
            case ORC:
                Main.outputPrint(getName() + " (" + getLiveLevelHP() + " HP) has attacked by truncheon ");
                damage = 20;
                break;
            case UNDEAD:
                Main.outputPrint(getName() + " (" + getLiveLevelHP() + " HP) has attacked by spear ");
                damage = 18;
                break;
            case ELF:
                Main.outputPrint(getName() + " (" + getLiveLevelHP() + " HP) has attacked by sword ");
                damage = 15;
                break;
        }
        enemiesArmy.attackHero(damage, this);
    }
}
