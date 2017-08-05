package com.QATestLab;

import java.util.Random;


public class Battle {

    private Random random = new Random();
    public static int indexOfNewPrivilege = -1;

    public Battle(Army oneSide, Army anotherSide) {


        Main.outputPrintln("!!!" + oneSide.getRace() + " fight against " + anotherSide.getRace() + "!!!");
        int numberOfStep = 0;

        do {
            int whoesTern = random.nextInt(2);
            numberOfStep++;
            if (whoesTern == 0) {
                Main.outputPrintln(" ");
                Main.outputPrintln(oneSide.getRace() + " is attacking, step #" + numberOfStep + ":");
                attack(oneSide, anotherSide);
            } else {
                Main.outputPrintln(" ");
                Main.outputPrintln(anotherSide.getRace() + " is attacking, step #" + numberOfStep + ":");
                attack(anotherSide, oneSide);
            }
            Main.outputPrintln("-----------------------------------");
            Main.outputPrintln(oneSide.getRace() + " have " + oneSide.listArmy.size() + " alive heroes");
            Main.outputPrintln(anotherSide.getRace() + " have " + anotherSide.listArmy.size() + " alive heroes");
        } while (oneSide.listArmy.size() != 0 && anotherSide.listArmy.size() != 0);
        gameOver();
    }

    private void attack(Army homeArmy, Army enemyArmy) {
        int indexPrivAttacked = -1;
        if (homeArmy.countPrivilege() != 0) {
            Main.outputPrintln("*** First is attacking Heroes from privilege group ***");
            int[] privilege = homeArmy.privilegeGroup();
            privilege = homeArmy.shuffleHeroes(privilege);
            for (int i : privilege) {
                if (enemyArmy.countAliveHeroes() != 0) {
                    homeArmy.listArmy.get(i).attack(homeArmy, enemyArmy);
                } else {
                    gameOver();
                }
            }
            Main.outputPrintln("*** The next attacking Heroes from usual group ***");
            int[] usual = homeArmy.usualGroup();
            usual = homeArmy.shuffleHeroes(usual);
            for (int i : usual) {
                if (i == indexPrivAttacked) {
                    continue;
                }
                if (enemyArmy.countAliveHeroes() != 0) {
                    if (indexOfNewPrivilege >= 0){
                        if (defineIfNewPrivilegeAttacked(usual, i, indexOfNewPrivilege)) {
                            homeArmy.listArmy.get(indexOfNewPrivilege).attack(homeArmy, enemyArmy);
                            indexPrivAttacked = indexOfNewPrivilege;
                            indexOfNewPrivilege = -1;
                        }
                    }
                    homeArmy.listArmy.get(i).attack(homeArmy, enemyArmy);
                } else {
                    gameOver();
                }
            }
        } else {
            Main.outputPrintln("*** There is no Heroes in privilege group ***");
            int[] usual = homeArmy.usualGroup();
            usual = homeArmy.shuffleHeroes(usual);
            for (int i : usual) {
                if (i == indexPrivAttacked) {
                    continue;
                }
                if (enemyArmy.countAliveHeroes() != 0) {
                    if (indexOfNewPrivilege >= 0){
                        if (defineIfNewPrivilegeAttacked(usual, i, indexOfNewPrivilege)) {
                            homeArmy.listArmy.get(indexOfNewPrivilege).attack(homeArmy, enemyArmy);
                            indexPrivAttacked = indexOfNewPrivilege;
                            indexOfNewPrivilege = -1;
                        }
                    }
                    homeArmy.listArmy.get(i).attack(homeArmy, enemyArmy);
                } else {
                    gameOver();
                }
            }
        }
    }

    boolean defineIfNewPrivilegeAttacked(int[] arr, int i, int indexOfNewPrivilege) {
        for (int a = 0; a < arr.length; a++) {
            if (a == indexOfNewPrivilege) {
                if ((a - i) >= 0) {
                    this.indexOfNewPrivilege = -1;
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private void gameOver() {
        Main.outputPrintln("Game over");
        if (Main.logfile != null) {
            Main.logfile.close();
        }
        System.exit(0);
    }


}
