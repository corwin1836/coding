package com.company;

public class Airport implements RefuelDelegate {

    private Runway[] runways;
    private AirplaneFleet landingList;
    private int tickCounter = 0;
    private AirplaneTakeoffFleet takeoffList;


    public Airport(int runwayNumber, int fleetSize) {
        runways = new Runway[runwayNumber];
        for (int i = 0; i < runways.length; i++) {
            Runway x = new Runway();
            runways[i] = x;
        }
        landingList = new AirplaneFleet(fleetSize, this);
        takeoffList = new AirplaneTakeoffFleet(this);
    }

    public void airportControl() {
        for (int i = 0; i < 3; i++) {
            if (!runways[i].inUse()) {
                if (tickCounter % 2 == 0) {
                   if (takeoffList.canTakeoffFleet()) {
                       Airplane nextOff = takeoffList.getNextTakeoff();
                       runways[i].takeOffPlane(nextOff);
                   } else {
                       System.out.println("Waiting for planes to take off.");
                   }
                } else {
                    Airplane leastFuel = landingList.removeLeastFuel();
                    runways[i].landPlane(leastFuel);
                }
            }
            runways[i].tick();
        }
        tickCounter++;
    }

    public void onRefuelCompleted(Airplane refuelComplete) {
        takeoffList.addAirplane(refuelComplete);
    }
}
