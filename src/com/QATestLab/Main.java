package com.QATestLab;

import java.io.PrintWriter;

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
	// write your code here
    }
}
