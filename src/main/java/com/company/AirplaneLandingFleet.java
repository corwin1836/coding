package com.company;

import com.company.interfaces.NumberGenerator;
import com.company.interfaces.RefuelDelegate;
import com.company.interfaces.TakeoffDelegate;

import java.util.ArrayList;
import java.util.Collections;

public class AirplaneLandingFleet {

    private NumberGenerator gen = new RandomNumberGenerator();
    private ArrayList<Airplane> fleet;
    private Airport delegate;
    private LandingPriorityCalculator priority;


    public AirplaneLandingFleet(Airplane[] landingList) {
        if (landingList.length < 1) {
            throw new IllegalStateException();
        }
        Collections.addAll(fleet, landingList);
        priority = new LandingPriorityCalculator();
    }


    public Airplane nextToLand(Route route) {
        Airplane[] retFleet = fleet.toArray(new Airplane[0]);
        return priority.nextToLand(retFleet, gen, route, delegate);
    }

    public void addAirplane(Airplane additional) {
        fleet.add(additional);
    }

    public ArrayList<Airplane> getFleet() {
        return fleet;
    }
}
