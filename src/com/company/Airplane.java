package com.company;

public class Airplane implements Tickable{

    private static int planeDesignation = 0;
    private int designation;
    private boolean off;
    public double fuel;
    private int landingTime;
    private int takeOffTime;
    NumberGenerator generator;

    public Airplane(NumberGenerator generator) {
        planeDesignation++;
        designation = planeDesignation;
        fuel = generator.range(0.0, 100.0);
        this.generator = generator;
    }

    public void takeOff() {
        takeOffTime = generator.range(5, 15);
        off = false;

    }

    public void landing() {
        landingTime = generator.range(5,15);
        off = true;
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
        if (takeOffTime > 0) {
            takeOffTime--;
            if (takeOffTime == 0) {
                off = true;
                System.out.println(designation + "Has taken off!");
            }
        }
        if (landingTime > 0) {
            landingTime--;
            if (landingTime == 0) {
                off = false;
                System.out.println(designation + "Has landed! YAY!");
            }
        }
    }
}
