package com.QATestLab;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army {
    private Race race;
    private HeroMagician magician;
    private HeroArcher[] archers;
    private HeroWarrior[] warriors;
    public List<Hero> listArmy = new ArrayList<>();
    private Random random = new Random();


    public Army(Race race) {
        int j = 1;
        this.race = race;
        magician = new HeroMagician(race, j);
        listArmy.add(magician);
        archers = new HeroArcher[3];
        for (int i = 0; i < archers.length; i++) {
            archers[i] = new HeroArcher(race, i + 1);
            listArmy.add(archers[i]);
        }
        warriors = new HeroWarrior[4];
        for (int i = 0; i < warriors.length; i++) {
            warriors[i] = new HeroWarrior(race, i + 1);
            listArmy.add(warriors[i]);
        }
    }

    public Race getRace() {
        return race;
    }


    public int makePrivilege(Hero heroPriv) {
        heroPriv.setPrivilege(false);
        int[] arrIndexUsual = usualGroup();
        if (arrIndexUsual.length == 0) {
            Main.outputPrintln("Some Hero, however all heroes have already had improvements");
        } else {
            int index = arrIndexUsual[random.nextInt(arrIndexUsual.length)];
            Main.outputPrintln(listArmy.get(index).getName());
            Hero hero = listArmy.get(index);
            listArmy.remove(hero);
            hero.setPrivilege(true);
            listArmy.add(index, hero);
            return index;
        }
        return -1;
    }

    public void makeBane() {
        int[] arrIndexUsual = usualGroupWhenBane();
        if (arrIndexUsual.length == 0) {
            Main.outputPrintln("Some Hero, however all heroes have already had bane");
        } else {
            int index = arrIndexUsual[random.nextInt(arrIndexUsual.length)];
            Main.outputPrintln(listArmy.get(index).getName() + " at next attack");
            Hero hero = listArmy.get(index);
            listArmy.remove(hero);
            hero.setBane(true);
            listArmy.add(index, hero);
        }

    }

    public void attackHero(double damage, Hero heroFighter) {
        if (damage > 0) {
            int index = random.nextInt(countAliveHeroes());
            Hero hero = listArmy.get(index);
            Main.outputPrint(hero.getName() + " (" + hero.getLiveLevelHP() + " HP); ");
            listArmy.remove(hero);
            if (heroFighter.isPrivilege() && !heroFighter.isBane()) {
                damage *= 1.5;
                heroFighter.setPrivilege(false);
                Main.outputPrint(heroFighter.getName() + " from privilege group, his damage is: " + damage + " HP");
            } else if (heroFighter.isBane() && this.race.equals(Race.ORC) && heroFighter.isPrivilege()) {
                Main.outputPrint("Privilege functions of " + heroFighter.getName() + " canceled by the Voodoo bane");
                heroFighter.setPrivilege(false);
                heroFighter.setBane(false);
            } else if (heroFighter.isBane() && this.race.equals(Race.UNDEAD) && !heroFighter.isPrivilege()) {
                damage /= 2;
                heroFighter.setBane(false);
                Main.outputPrint("Damage of " + heroFighter.getName() + " was reduced by Necromancer bane to " + damage + " HP");
            } else if (heroFighter.isBane() && this.race.equals(Race.UNDEAD) && heroFighter.isPrivilege()) {
                damage = damage * 1.5 / 2;
                Main.outputPrint(heroFighter.getName() + " from privilege group, however he has Necromancer bane, so his damage is " + damage + " HP");
                heroFighter.setPrivilege(false);
                heroFighter.setBane(false);
            }
            if (!hero.damage(damage)) {
                listArmy.add(index, hero);
            }
        }
    }


    // indexes of usual group
    public int[] usualGroup() {
        int privilegeHeroes = countPrivilege();
        int aliveHeroes = countAliveHeroes();
        int[] usualGroup = new int[(aliveHeroes) - privilegeHeroes];
        int i = 0;
        for (Hero hero : listArmy) {
            if (!hero.isPrivilege()) {
                usualGroup[i++] = listArmy.indexOf(hero);
            }
        }
        return usualGroup;
    }

    // Only when bane group available
    public int[] usualGroupWhenBane() {
        int baneHeroes = countBane();
        int aliveHeroes = countAliveHeroes();
        int[] usualGroup = new int[(aliveHeroes) - baneHeroes];
        int i = 0;
        for (Hero hero : listArmy) {
            if (!hero.isBane()) {
                usualGroup[i++] = listArmy.indexOf(hero);
            }
        }
        return usualGroup;
    }

    // indexes of privilege group
    public int[] privilegeGroup() {
        int[] privilegeGroup = new int[countPrivilege()];
        int i = 0;
        for (Hero hero : listArmy) {
            if (hero.isPrivilege()) {
                privilegeGroup[i++] = listArmy.indexOf(hero);
            }
        }
        return privilegeGroup;
    }

    // to reach random steps
    public int[] shuffleHeroes(int[] heroes) {
        int index;
        int temp;
        for (int i = heroes.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = heroes[index];
            heroes[index] = heroes[i];
            heroes[i] = temp;
        }
        return heroes;
    }

    public int countAliveHeroes() {
        return listArmy.size();
    }

    public int countPrivilege() {
        int countPrivilege = 0;
        for (Hero hero : listArmy) {
            if (hero.isPrivilege()) {
                countPrivilege++;
            }
        }
        return countPrivilege;
    }

    public int countBane() {
        int countBane = 0;
        for (Hero hero : listArmy) {
            if (hero.isBane()) {
                countBane++;
            }
        }
        return countBane;
    }
}
