package com.company;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class Main {
    private static int tickCounter = 0;

    public static void main(String[] args) {
        if (args.length == 0) {
            //throw new Exception("Required program parameters not met, exiting program.");
    }
        Timer timer = new Timer();
        Airport laguardia = null;
        try {
            laguardia = new Airport(3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (goSequence(args)) {
            timer.printCurrentTime();
            try {
                laguardia.airportControl();
            } catch (Exception e) {
                e.printStackTrace();
            }
            tickCounter++;
            timer.tick();
            try {
                sleep(programRunTime(args));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (args.length != 3) {
            //throw new Exception("You have not provided a output file while still providing a tick count.");
        }
        Writer writer = new MyFileWriter();
        AirportSerializer airportSerializer = new AirportSerializer();
        try {
            airportSerializer.serializer(writer, args[2], laguardia);
        } catch (IOException e) {
            e.printStackTrace();
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