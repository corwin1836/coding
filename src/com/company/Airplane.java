package com.company;

public class Airplane {

    private static int planeDesignation = 0;
    private int designation;
    private boolean off;
    public double fuel;

    public Airplane() {
        planeDesignation ++;
        designation = planeDesignation;
        fuel = Math.random()*100;
    }

    public void takeOff() {
        off = true;
        System.out.println(designation +"Has taken off!");
    }

    public void landing() {
        off = false;
        System.out.println(designation +"Has landed! YAY!");
    }

    public double getFuel() {
        return fuel;
    }
}
