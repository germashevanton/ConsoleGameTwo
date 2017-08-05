package com.QATestLab;

import java.util.Random;


public class Battle {

    private Random random = new Random();

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

    }

    private void attack(Army oneSide, Army anotherSide) {

    }


}
