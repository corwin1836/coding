package com.company;

public class Main {
    private static int tickCounter = 0;

    public static void main(String[] args) {
        Timer timer = new Timer();
        AirplaneFleet list = new AirplaneFleet(100);

        Runway[] runways = new Runway[3];
        for (int i = 0; i < 3; i++) {
            runways[i] = new Runway();
        }

        while (goSequence(args)) {
            timer.printCurrentTime();
            for (int i = 0; i < 3; i++) {
                if (!runways[i].inUse()) {
                    if (tickCounter % 2 == 0) {
                        Airplane nextOff = list.setFleetPosition();
                        runways[i].takeOffPlane(nextOff);
                    } else {
                        Airplane leastFuel = list.removeLeastFuel();
                        runways[i].landPlane(leastFuel);
                    }
                }
                runways[i].tick();
            }
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