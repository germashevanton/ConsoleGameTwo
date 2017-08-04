package com.QATestLab;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Army {
    private Race race;
    private HeroMagician magician;
    private HeroArcher[] archers;
    private HeroWarrior[] warriors;
    private Map<Integer, Hero> mapArmy = new HashMap<>();
    private int[] aliveHeroes;
    public List<Hero> listArmy = new ArrayList<>();
    Random random = new Random();





    public Army(Race race) {
        int j = 1;
        this.race = race;
        magician = new HeroMagician(race, j);
        mapArmy.put(j++, magician);
        listArmy.add(magician);
        archers = new HeroArcher[3];
        for (int i = 0; i < archers.length; i++) {
            archers[i] = new HeroArcher(race, j);
            mapArmy.put(j++, archers[i]);
            listArmy.add(archers[i]);
        }
        warriors = new HeroWarrior[4];
        for (int i = 0; i < warriors.length; i++) {
            warriors[i] = new HeroWarrior(race, j);
            mapArmy.put(j++, warriors[i]);
            listArmy.add(warriors[i]);
        }
        aliveHeroes = mapArmy.keySet().stream().mapToInt(Integer::intValue).toArray();
    }


    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int[] getAliveHeroes() {
        return aliveHeroes;
    }

    public void setAliveHeroes(int[] aliveHeroes) {
        this.aliveHeroes = aliveHeroes;
    }

    public void makePrivilege(int index){
        Hero hero = listArmy.get(index);
        hero.setPrivilege(true);
        listArmy.add(index, hero);
    }

///sdsdsdsd



    // Only when privilege group available
    public int[] usualGroupWhenPrivilege() {
        int privilegeHeroes = countPrivilege();
        int aliveHeroes = countAliveHeroes();
        int[] usualGroup = new int[(aliveHeroes) - privilegeHeroes];
        int i = 0;
        for (Hero hero : listArmy) {
            if (!hero.isPrivilege()) {
                usualGroup[i++] = listArmy.indexOf(hero); /////////
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
                usualGroup[i++] = listArmy.indexOf(hero); /////////
            }
        }
        return usualGroup;
    }

    // Only when privilege group available
    public int[] privilegeGroup() {
        int[] privilegeGroup = new int[countPrivilege()];
        int i = 0;
        for (Hero hero : listArmy) {
            if (hero.isPrivilege()) {
                privilegeGroup[i++] = listArmy.indexOf(hero); /////////
            }
        }
        return privilegeGroup;
    }

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

    public int countAliveHeroes(){
        return listArmy.size();
    }


    public int countPrivilege(){
        int countPrivilege = 0;
        for (Hero hero : listArmy) {
            if (hero.isPrivilege()) {
                countPrivilege++;
            }
        }
        return countPrivilege;
    }

    public int countBane(){
        int countBane = 0;
        for (Hero hero : listArmy) {
            if (hero.isBane()) {
                countBane++;
            }
        }
        return countBane;
    }
}
