package com.company;

public class AirplaneLandingFleet {

    private RandomNumberGenerator gen = new RandomNumberGenerator();
    private Airplane[] fleet;
    private RefuelDelegate delegate;
    LandingPriorityCalculator priority;

    public AirplaneLandingFleet(int fleetSize, RefuelDelegate delegate) {
        if (fleetSize < 1)
            throw new IllegalStateException();
        fleet = new Airplane[fleetSize];
        this.delegate = delegate;
        for (int i = 0; i < fleet.length; i++) {
            Airplane x = new Airplane(gen, false, delegate);
            fleet[i] = x;
        }
        priority = new LandingPriorityCalculator();
    }


    public Airplane nextToLand() {
    return priority.nextToLand(fleet, gen, delegate);
    }
}
