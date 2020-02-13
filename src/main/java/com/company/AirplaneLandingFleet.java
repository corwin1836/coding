package com.company;

import com.company.interfaces.NumberGenerator;
import com.company.interfaces.RefuelDelegate;
import com.company.interfaces.TakeoffDelegate;

public class AirplaneLandingFleet {

    private NumberGenerator gen = new RandomNumberGenerator();
    private Airplane[] fleet;
    private Airport delegate;
    private LandingPriorityCalculator priority;


    public AirplaneLandingFleet(Airplane[] landingList) {
        if (landingList.length < 1) {
            throw new IllegalStateException();
        }
        fleet = landingList;
        priority = new LandingPriorityCalculator();
    }


    public Airplane nextToLand(Route route) {
        return priority.nextToLand(fleet, gen, route, delegate);
    }

    public Airplane[] getFleet() {
        return fleet;
    }
}
