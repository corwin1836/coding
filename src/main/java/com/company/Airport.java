package com.company;

import java.io.IOException;

public class Airport implements RefuelDelegate {

    private Runway[] runways;
    private AirplaneLandingFleet landingList;
    private int tickCounter = 0;
    private AirplaneTakeoffFleet takeoffList;

    public Airport(int runwayNumber) throws IOException {
        NumberGenerator gen = new RandomNumberGenerator();
        MyFileReader reader = new MyFileReader();
        FileParser parser = new FileParser(reader);
        Airplane[] outgoing = parser.buildOutgoing(gen, this);
        Airplane[] incoming = parser.buildIncoming(gen, this);
        runways = new Runway[runwayNumber];
        for (int i = 0; i < runways.length; i++) {
            Runway x = new Runway();
            runways[i] = x;
        }
        landingList = new AirplaneLandingFleet(incoming);
        takeoffList = new AirplaneTakeoffFleet(outgoing);
    }

    public void airportControl() {
        for (int i = 0; i < 3; i++) {
            if (!runways[i].inUse()) {
                if (tickCounter % 2 == 0) {
                    final int x = i;
                    takeoffList.firstToTakeoff().map((nextOff)->{
                        runways[x].takeOffPlane(nextOff);
                        return null;
                    });

                } else {
                    Airplane leastFuel = landingList.nextToLand();
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

    public AirplaneTakeoffFleet getTakeoffList() {
        return takeoffList;
    }

    public AirplaneLandingFleet getLandingList() {
        return landingList;
    }
}
