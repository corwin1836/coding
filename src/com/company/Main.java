package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int userInput = Integer.parseInt(args[0]);
        int tickCounter = 0;
        //int store = 0;

        Airplane [] list = new Airplane[100];
        for (int i=0; i<list.length; i++){
            Airplane x = new Airplane();
            list[i] = x;
        }
        while (tickCounter < userInput) {
            if (tickCounter % 2 == 0) {
                list[0].takeOff();
                list[0] = new Airplane();
                tickCounter++;
            } else {
                int leastFuel = 0;
                for (int i = 0; i<list.length; i++) {
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
}
