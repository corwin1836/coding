package com.company;

public class Airplane implements Tickable {

    private static int planeDesignation = 0;
    private int designation;
    private boolean off;
    private double fuel;
    private int landingTime;
    private int takeOffTime;
    private int taxiTime;
    private NumberGenerator generator;
    private String identifier;
    UniqueGenerator unique = new UniqueGenerator();
    private static String lastIdentifier = "AAA-111";
    private AirplaneModel model;
    private AirplaneMake make;

    public Airplane(NumberGenerator generator) {
        planeDesignation++;
        designation = planeDesignation;
        AirplaneMake make = AirplaneMake.makeGenerator();
        AirplaneModel model = AirplaneModel.modelGenerator(make);
        this.model = model;
        this.make = make;
        fuel = generator.range(0.0, model.getFuel());
        this.generator = generator;
    }

//    Each flight has a unique identifier.
//    The identifiers should be in the format XXX-YYY, where X is a capital letter and Y is a decimal integer.
//    This is not the ID of a plane, this is the ID of the flight that the plane is embarking on.



    public void takeOff() {
        taxiTime = generator.range(3, 5);
        takeOffTime = generator.range(5, 15);
        off = false;
        try {
            identifier = unique.charGenerator(lastIdentifier);
        } catch (Exception blargh) {
            blargh.printStackTrace();
        }
        lastIdentifier = identifier;

    }

    public void landing() {
        landingTime = generator.range(5, 15);
        off = true;
        try {
            identifier = unique.charGenerator(lastIdentifier);
        } catch (Exception blargh) {
            blargh.printStackTrace();
        }
        lastIdentifier = identifier;
    }

    public double getFuel() {
        return fuel;
    }

    public boolean hasTakenOff() {
        return off;
    }

    public boolean hasLanded() {
        return !off;
    }

    public void tick() {
        if (taxiTime > 0) {
            taxiTime--;
            return;
        }
        if (takeOffTime > 0) {
            takeOffTime--;
            if (takeOffTime == 0) {
                off = true;
                System.out.println(designation +" "+ identifier + " " + make + " " + model +" "+ "Has taken off!");
            }
        }
        if (landingTime > 0) {
            landingTime--;
            if (landingTime == 0) {
                off = false;
                System.out.println(designation +" "+ identifier +" "+ make + " " + model +" "+ "Has landed! YAY!");
            }
        }
    }
}
