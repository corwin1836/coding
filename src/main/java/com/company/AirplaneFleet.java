package com.company;

public class AirplaneFleet {

    private RandomNumberGenerator gen = new RandomNumberGenerator();
    private Airplane[] fleet;
    private RefuelDelegate delegate;

    public AirplaneFleet(int fleetSize, RefuelDelegate delegate) {
        if (fleetSize < 1)
            throw new IllegalStateException();
        fleet = new Airplane[fleetSize];
        this.delegate = delegate;
        for (int i = 0; i < fleet.length; i++) {
            Airplane x = new Airplane(gen, false, delegate);
            fleet[i] = x;
        }
    }

    public Airplane removeLeastFuel() {
        Airplane minFuel = null;
        int leastFuel = 0;
        for (int j = 0; j < fleet.length; j++) {
            if (fleet[j].getFuel() <= fleet[leastFuel].getFuel()) {
                leastFuel = j;
                minFuel = fleet[leastFuel];
            }
        }
        fleet[leastFuel] = new Airplane(gen, false, delegate);
        return minFuel;
    }
}