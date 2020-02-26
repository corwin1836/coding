package com.company;

import com.company.fileInputs.FileParser;
import com.company.fileInputs.MyFileReader;
//import com.company.fileOutputs.AirportSerializer;
import com.company.fileOutputs.MyFileWriter;
import com.company.interfaces.Writer;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class Main {
    private static int tickCounter = 0;

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            //throw new Exception("Required program parameters not met, exiting program.");
        }
        Timer timer = new Timer();
        MyFileReader reader = new MyFileReader();
        FileParser parser = new FileParser(reader);
        AirportNetwork laguardia = new AirportNetwork(parser);
        while (goSequence(args)) {
            timer.printCurrentTime();
            laguardia.airportNetworkControl();
            tickCounter++;
            timer.tick();
            try {
                sleep(programRunTime(args));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (args.length != 3) {
                //throw new Exception("You have not provided a output file while still providing a tick count.");
            }
//            Writer writer = new MyFileWriter();
//            AirportSerializer airportSerializer = new AirportSerializer();
//            try {
//                airportSerializer.serializer(writer, args[2], laguardia);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
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