package com.QATestLab;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {


    // LogFile
    public static PrintWriter logfile;

    // write to the file and console using print
    public static void outputPrint(final String str) {
        System.out.print(str);
        logfile.print(str);
    }

    // write to the file and console using println
    public static void outputPrintln(final String str) {
        System.out.println(str);
        logfile.println(str);
    }

    public static void main(String[] args) {
        Army oneSide;
        Army anotherSide;
        Random random = new Random();
        try {
            logfile = new PrintWriter(new FileWriter("LogFile.txt"));

            if (random.nextInt(2) == 0){
                oneSide = new Army(Race.PEOPLE);
            } else {
                oneSide = new Army(Race.ELF);
            }

            if (random.nextInt(2) == 0){
                anotherSide = new Army(Race.ORC);
            } else {
                anotherSide = new Army(Race.UNDEAD);
            }

            new Battle(oneSide, anotherSide);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        if (logfile != null) {
            logfile.close();
        }
    }
    }
}
