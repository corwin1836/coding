package com.company;

public class Airplane {

    private static int planeDesignation = 0;
    private int designation;
    private boolean off;
    public double fuel;
    private int landingTime;
    private int takeOffTime;

    public Airplane() {
        planeDesignation++;
        designation = planeDesignation;
        fuel = Math.random() * 100;

    }

    public void takeOff() {
        takeOffTime = (int) (Math.random() * 10 + 5);
        off = false;

    }

    public void landing() {
        landingTime = (int) (Math.random() * 10 + 5);
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
