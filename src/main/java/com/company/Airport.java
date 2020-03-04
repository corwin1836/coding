// This needs to be updated to take an incoming fleet based off of the destinations of planes within a json file.
// Additionally, need to update the build the outgoing planes in the constructor.



package com.company;

import com.company.fileInputs.FileParser;
import com.company.fileInputs.MyFileReader;
import com.company.interfaces.AirplaneTakeoffDelegate;
import com.company.interfaces.AirportTakeoffDelegate;
import com.company.interfaces.NumberGenerator;
import com.company.interfaces.RefuelDelegate;
import com.company.interfaces.AirplaneTakeoffDelegate;

import java.io.IOException;

public class Airport implements RefuelDelegate, AirplaneTakeoffDelegate {

    private Runway[] runways;
    private AirplaneLandingFleet landingList;
    private int tickCounter = 0;
    private AirplaneTakeoffFleet takeoffList;
    private String airportName;
    private AirportTakeoffDelegate takenoff;

    public Airport(int runwayNumber, String airportName) {
//        NumberGenerator gen = new RandomNumberGenerator();
//        MyFileReader reader = new MyFileReader();
//        FileParser parser = new FileParser(reader);
//        Airplane[] outgoing = parser.buildOutgoing(gen, this);
//        Airplane[] incoming = parser.buildIncoming(gen, this);
        runways = new Runway[runwayNumber];
        for (int i = 0; i < runways.length; i++) {
            Runway x = new Runway();
            runways[i] = x;
        }
        this.airportName = airportName;
    }

    public void airportControl() {
        for (int i = 0; i < runways.length; i += 1) {
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

    public String getAirportName() {
        return airportName;
    }

    public void setAirportTakenoffDelegate(AirportTakeoffDelegate delegate){
        takenoff = delegate;
    }

    public void onTakeoff(Airplane takeoffComplete) {
        takeoffList.removeAirplane(takeoffComplete);
        takenoff.onTakeoff(takeoffComplete, this);
    }

}
