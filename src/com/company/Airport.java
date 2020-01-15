package com.company;

public class Airport {

    private Runway[] runways;
    private AirplaneFleet list;
    private int tickCounter = 0;


    public Airport(int runwayNumber, int fleetSize) {
        runways = new Runway[runwayNumber];
        for (int i = 0; i < runways.length; i++) {
            Runway x = new Runway();
            runways[i] = x;
        }
        list = new AirplaneFleet(fleetSize);
    }

    public void airportControl() {
        for (int i = 0; i < 3; i++) {
            if (!runways[i].inUse()) {
                if (tickCounter % 2 == 0) {
                    Airplane nextOff = list.setFleetPosition();
                    runways[i].takeOffPlane(nextOff);
                } else {
                    Airplane leastFuel = list.removeLeastFuel();
                    runways[i].landPlane(leastFuel);
                }
            }
            runways[i].tick();
        }
        tickCounter++;
    }
}
