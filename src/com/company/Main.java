package com.company;

import java.util.ArrayList;

public class Main {
    private static int tickCounter = 0;

    public static void main(String[] args) {
        //int store = 0;

        Airplane[] list = new Airplane[100];
        for (int i = 0; i < list.length; i++) {
            Airplane x = new Airplane();
            list[i] = x;
        }
        while (goSequence(args)) {
            if (tickCounter % 2 == 0) {
                list[0].takeOff();
                list[0] = new Airplane();
                list[0].takeOff();
                list[0] = new Airplane();
                list[0].takeOff();
                list[0] = new Airplane();
                tickCounter++;
            } else {
                int leastFuel = 0;
                for (int i = 0; i < list.length; i++) {
                    if (list[i].getFuel() < list[leastFuel].getFuel()) {
                        leastFuel = i;
                    }
                }
                list[leastFuel].landing();
                list[leastFuel] = new Airplane();
                leastFuel = 0;
                for (int i = 0; i < list.length; i++) {
                    if (list[i].getFuel() < list[leastFuel].getFuel()) {
                        leastFuel = i;
                    }
                }
                list[leastFuel].landing();
                list[leastFuel] = new Airplane();
                leastFuel = 0;
                for (int i = 0; i < list.length; i++) {
                    if (list[i].getFuel() < list[leastFuel].getFuel()) {
                        leastFuel = i;
                    }
                }
                list[leastFuel].landing();
                list[leastFuel] = new Airplane();
                tickCounter++;
            }
        }
    }

    public static boolean goSequence(String[] args) {
        int userInput = 0;
        if (args.length == 0) {
            return true;
        } else {
            userInput = Integer.parseInt(args[0]);
        }
        if (tickCounter < userInput) {
            return true;
        } else {
            return false;
        }
    }
}
