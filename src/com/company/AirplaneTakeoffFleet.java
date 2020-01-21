package com.company;

import java.util.ArrayList;

public class AirplaneTakeoffFleet {

    private RandomNumberGenerator gen = new RandomNumberGenerator();
    private ArrayList<Airplane> fleet;
    private static final int FLEET_CAPACITY = 100;

    public AirplaneTakeoffFleet(RefuelDelegate refuelDelegate) {
        fleet = new ArrayList<>(FLEET_CAPACITY);
        for (int i = 0; i < FLEET_CAPACITY; i++) {
            fleet.add(new Airplane(gen, true, refuelDelegate));
        }
    }

    public boolean canTakeoffFleet() {
        return !fleet.isEmpty();
    }

    public Airplane getNextTakeoff() {
        Airplane ret =fleet.get(0);
        return ret;
    }

    public void addAirplane(Airplane newAirplane) {
        fleet.add(newAirplane);
    }
}