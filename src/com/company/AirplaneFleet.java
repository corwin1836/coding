package com.company;

public class AirplaneFleet {

    private RandomNumberGenerator gen = new RandomNumberGenerator();
    private Airplane[] fleet;


    public AirplaneFleet(int fleetSize) {
        fleet = new Airplane[fleetSize];
        for (int i = 0; i < fleet.length; i++) {
            Airplane x = new Airplane(gen);
            fleet[i] = x;
        }
    }

    public Airplane setFleetPosition() {
        Airplane ret = fleet[0];
        fleet[0] = new Airplane(gen);
        return ret;
    }

    public Airplane removeLeastFuel() {
        Airplane minFuel = null;
        int leastFuel = 0;
        for (int j = 0; j < fleet.length; j++) {
            if (fleet[j].getFuel() < fleet[leastFuel].getFuel()) {
                leastFuel = j;
                minFuel = fleet[leastFuel];
            }
        }
        fleet[leastFuel] = new Airplane(gen);
        return minFuel;
    }
}