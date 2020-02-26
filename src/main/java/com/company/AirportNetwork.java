package com.company;

import com.company.fileInputs.FileParser;
import com.company.fileInputs.MyFileReader;
import com.company.interfaces.AirportTakeoffDelegate;
import com.company.interfaces.AirportTakeoffDelegate;
import com.company.models.Airline;
import com.company.models.Airports;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AirportNetwork implements AirportTakeoffDelegate {

    private Set<Airport> airports;

    public AirportNetwork(FileParser parser) {
        Map<Airport, AirplaneTakeoffFleet> airportState;
        airportState = parser.initialState();
        airports = airportState.keySet();
    }


    @Override
    public void onTakeoff(Airplane takeoffComplete, Airport previousAirport) {
        String airplaneName = takeoffComplete.getUniqueIdentifier();
        String previousAirportName = previousAirport.getAirportName();
        Route nextDestination = takeoffComplete.getRoute();
        String destination0 = nextDestination.getDestination0();
        String destination1 = nextDestination.getDestination1();
        String destinationMaybe = previousAirport.getAirportName();
        String destinationActual;
        AirplaneLandingFleet newFleetToAddTo;
        if (destinationMaybe.equals(destination0)) {
            destinationActual = destination1;
        } else {
            destinationActual = destination0;
        }
        for (Airport name : airports) {
            String currentName = name.getAirportName();
            if (destinationActual.equals(currentName)) {
                newFleetToAddTo = name.getLandingList();
                newFleetToAddTo.addAirplane(takeoffComplete);
                takeoffComplete.setTakenOff(name);
                System.out.println("Airplane: "+airplaneName+ "has departed from: "+previousAirportName+ " heading to: "+destinationActual);
                break;
            }
        }

    }

    public void airportNetworkControl() {
        for (Airport airport : airports) {
            airport.airportControl();
        }
    }

}