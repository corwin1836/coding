package com.company;

public class AirplaneLandingFleet {

    private NumberGenerator gen = new RandomNumberGenerator();
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


    public Airplane nextToLand() throws Exception{
        return priority.nextToLand(fleet, gen, delegate);
    }

    public Airplane[] getFleet() {
        return fleet;
    }
}