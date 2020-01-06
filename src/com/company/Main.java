package com.company;

public class Main {
    private static int tickCounter = 0;

    public static void main(String[] args) {
        Airplane[] list = new Airplane[100];
        for (int i = 0; i < list.length; i++) {
            Airplane x = new Airplane();
            list[i] = x;
        }

        Runway [] runways = new Runway [3];
        for (int i = 0; i < 3; i++) {
            runways[i] = new Runway();
        }

        while (goSequence(args)) {
            for (int i = 0; i < 3; i++) {
                if (runways[i].inUse()) {
                    continue;
                } else {
                    runways[i].setInUse();
                    if (tickCounter % 2 == 0) {
                        list[0].takeOff();
                    } else {
                        int leastFuel = 0;
                        for (int j = 0; j < list.length; j++) {
                            if (list[j].getFuel() < list[leastFuel].getFuel()) {
                                leastFuel = j;
                            }
                        }
                        list[leastFuel].landing();
                        list[leastFuel] = new Airplane();
                    }
                }
                runways[i].setAvailable();
            }
            tickCounter ++;
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
