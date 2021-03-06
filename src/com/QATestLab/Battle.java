package com.QATestLab;

import java.util.Arrays;
import java.util.Random;


public class Battle {

    private Random random = new Random();
    public static int indexOfNewPrivilege = -1;
    private int actionCount = 1;

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
        gameOver(oneSide, anotherSide);
    }

    private void attack(Army homeArmy, Army enemyArmy) {
        indexOfNewPrivilege = -1;
        int[] privilege = homeArmy.privilegeGroup();
        int[] usual = homeArmy.usualGroup();
        if (homeArmy.countPrivilege() != 0) {
            Main.outputPrintln("*** First is attacking Heroes from privilege group ***");
            privilege = homeArmy.shuffleHeroes(privilege);
            for (int i : privilege) {
                if (enemyArmy.countAliveHeroes() != 0) {
                    Main.outputPrint("Action " + actionCount++ + ":  ");
                    homeArmy.listArmy.get(i).attack(homeArmy, enemyArmy);
                } else {
                    gameOver(homeArmy, enemyArmy);
                }
            }
            Main.outputPrintln("*** The next attacking Heroes from usual group ***");
            usualGroupAction(homeArmy, enemyArmy, usual);
        } else {
            Main.outputPrintln("*** There is no Heroes in privilege group ***");
            usualGroupAction(homeArmy, enemyArmy, usual);
        }
    }

    // if magician make improvements and this Hero has not attacked yet, he is attacking immediately
    private void usualGroupAction(Army homeArmy, Army enemyArmy, int[] usual) {
        int indexPrivAttacked = -1;
        int index;
        usual = homeArmy.shuffleHeroes(usual);
        // System.out.println(Arrays.toString(usual)); //for test
        for (int i = 0; i < usual.length; i++) {
            index = usual[i];
            //System.out.println(index); //for test
            if (index == indexPrivAttacked) {
                continue;
            }
            if (enemyArmy.countAliveHeroes() != 0) {
                if (indexOfNewPrivilege >= 0) {
                    //System.out.println("ind = " + indexOfNewPrivilege); //for test
                    if (defineIfNewPrivilegeAttacked(usual, i, indexOfNewPrivilege)) {
                        Main.outputPrintln(homeArmy.listArmy.get(indexOfNewPrivilege).getName() + " became privilege during attack " +
                                "and he is attacking immediately");
                        Main.outputPrint("Action " + actionCount++ + ":  ");
                        homeArmy.listArmy.get(indexOfNewPrivilege).attack(homeArmy, enemyArmy);
                        indexPrivAttacked = indexOfNewPrivilege;
                        indexOfNewPrivilege = -1;
                        i -=1;
                    } else {
                        Main.outputPrint("Action " + actionCount++ + ":  ");
                        homeArmy.listArmy.get(index).attack(homeArmy, enemyArmy);
                    }
                } else {
                    Main.outputPrint("Action " + actionCount++ + ":  ");
                    homeArmy.listArmy.get(index).attack(homeArmy, enemyArmy);
                }
            } else {
                gameOver(homeArmy, enemyArmy);
            }
        }
    }

    private boolean defineIfNewPrivilegeAttacked(int[] arr, int i, int indexOfNewPrivilege) {
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == indexOfNewPrivilege) {
                if ((a - i) < 0) {
                    this.indexOfNewPrivilege = -1;
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private void gameOver(Army oneSide, Army anotherSide) {
        Main.outputPrintln(" ");
        Main.outputPrintln("Game over");

        if (oneSide.listArmy.size() != 0) {
            Main.outputPrintln("!!!" + oneSide.getRace() + " are winners!!!");
            Main.outputPrintln("At winners army have left alive Heroes:");
            for (Hero hero : oneSide.listArmy) {
                Main.outputPrintln(hero.getName() + " with live level " + hero.getLiveLevelHP() + " HP");
            }
        } else {
            Main.outputPrintln("!!!" + anotherSide.getRace() + " are winners!!!");
            Main.outputPrintln("At winners army have left alive Heroes:");
            for (Hero hero : anotherSide.listArmy) {
                Main.outputPrintln(hero.getName() + " with live level " + hero.getLiveLevelHP() + " HP");
            }
        }

        if (Main.logfile != null) {
            Main.logfile.close();
        }
        System.exit(0);
    }


}
