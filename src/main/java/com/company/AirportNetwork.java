package com.company;

import com.company.fileInputs.FileParser;
import com.company.interfaces.AirportTakeoffDelegate;

import java.util.Map;
import java.util.Set;

public class AirportNetwork implements AirportTakeoffDelegate {

    private Set<Map.Entry<Airport, AirplaneTakeoffFleet>> airports;

    public AirportNetwork(FileParser parser) {
        Map<Airport, AirplaneTakeoffFleet> airportState;
        airportState = parser.initialState();
        airports = airportState.entrySet();
        for (Map.Entry<Airport, AirplaneTakeoffFleet> name : airports) {
            Airport current = name.getKey();
            current.setAirportTakenoffDelegate(this);
            AirplaneTakeoffFleet thisFleet = name.getValue();
            current.setTakeoffList(thisFleet);
        }
    }


    @Override
    public void onTakeoff(Airplane takeoffComplete, Airport currentAirport) {
        String airplaneName = takeoffComplete.getUniqueIdentifier();
        Route route = takeoffComplete.getRoute();
        String destination0 = route.getDestination0();
        String destination1 = route.getDestination1();
        String currentAirportName = currentAirport.getAirportName();
        String finalDestination;
        if (currentAirportName.equals(destination0)) {
            finalDestination = destination1;
        } else {
            finalDestination = destination0;
        }
        for (Map.Entry<Airport, AirplaneTakeoffFleet> entry : airports) {
            Airport airport = entry.getKey();
            String airportName = airport.getAirportName();
            if (finalDestination.equals(airportName)) {
                AirplaneLandingFleet newFleetToAddTo = airport.getLandingList();
                newFleetToAddTo.addAirplane(takeoffComplete);
                takeoffComplete.setTakenOffDelegate(airport);
                String output = String.format("Airplane: %s has departed from: %s heading to  %s!", airplaneName, currentAirportName, finalDestination);
                System.out.println(output);
                break;
            }
        }
    }

    public void airportNetworkControl() {
        for (Map.Entry<Airport, AirplaneTakeoffFleet> airportAirplaneTakeoffFleetEntry: airports) {
            Airport airport = airportAirplaneTakeoffFleetEntry.getKey();
            AirplaneTakeoffFleet offFleet = airportAirplaneTakeoffFleetEntry.getValue();
            airport.airportControl(offFleet);
        }
    }
}