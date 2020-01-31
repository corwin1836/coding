package com.company;

public class AirplaneLandingFleet {

    private RandomNumberGenerator gen = new RandomNumberGenerator();
    private Airplane[] fleet;
    private RefuelDelegate delegate;
    LandingPriorityCalculator priority;


    public AirplaneLandingFleet(Airplane[] landingList) {
        if (landingList.length < 1) {
            throw new IllegalStateException();
        }
        fleet = landingList;
        priority = new LandingPriorityCalculator();
    }


    public Airplane nextToLand() {
        return priority.nextToLand(fleet, gen, delegate);
    }

    public Airplane[] getFleet() {
        return fleet;
    }
}
