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
        runways = new Runway[runwayNumber];
        for (int i = 0; i < runways.length; i++) {
            Runway x = new Runway();
            runways[i] = x;
        }
        this.airportName = airportName;
        Airplane[] landingFleetArray = new Airplane[0];
        landingList = new AirplaneLandingFleet(landingFleetArray);

    }

    public void airportControl(AirplaneTakeoffFleet takeoffList) {
        for (int i = 0; i < runways.length; i += 1) {
            if (!runways[i].inUse()) {
                if (tickCounter % 2 == 0) {
                    final int x = i;
                    takeoffList.firstToTakeoff().map((nextOff)->{
                        runways[x].takeOffPlane(nextOff);
                        return null;
                    });

                } else {
                    int fleetSize = landingList.getFleetSize();
                    if (fleetSize >= 1) {
                        Airplane leastFuel = landingList.nextToLand();
                        runways[i].landPlane(leastFuel);
                    }
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

    public void setTakeoffList(AirplaneTakeoffFleet fleet) {
        takeoffList = fleet;
    }

    public void onTakeoff(Airplane takeoffComplete) {
        takeoffList.removeAirplane(takeoffComplete);
        takenoff.onTakeoff(takeoffComplete, this);
    }

}
