package com.company;

public class Main {
    private static int tickCounter = 0;

    public static void main(String[] args) {
        Timer timer = new Timer();

        Airport laguardia = new Airport(3, 100);
        while (goSequence(args)) {
            timer.printCurrentTime();
            laguardia.airportControl();
            tickCounter++;
            timer.tick();
        }
    }

    public static boolean goSequence(String[] args) {
        int userInput;
        if (args.length == 0) {
            return true;
        } else {
            userInput = Integer.parseInt(args[0]);
        }
        return tickCounter < userInput;
    }
}