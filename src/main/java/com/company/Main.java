package com.company;

import static java.lang.Thread.sleep;

public class Main {
    private static int tickCounter = 0;

    public static void main(String[] args) throws InterruptedException, Exception {
        if (args.length == 0) {
            throw new Exception("Required program parameters not met, exiting program.");
    }
        Timer timer = new Timer();
        Airport laguardia = new Airport(3);
        while (goSequence(args)) {
            timer.printCurrentTime();
            laguardia.airportControl();
            tickCounter++;
            timer.tick();
            sleep(programRunTime(args));
        }
    }

    public static boolean goSequence(String[] args) {
        int userInput;
        if (args.length < 2) {
            return true;
        } else {
            userInput = Integer.parseInt(args[1]);
        }
        return tickCounter < userInput;
    }

    public static int programRunTime(String [] args) {

        String runSpeed = args[0];
        if (runSpeed.equals("u")) {
            return 1000;
        } else {
            return 0;
        }

    }
}