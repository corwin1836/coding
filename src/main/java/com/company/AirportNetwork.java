package com.company;

import com.company.fileInputs.FileParser;
import com.company.fileInputs.MyFileReader;
import com.company.interfaces.TakeoffDelegate;
import com.company.models.Airline;
import com.company.models.Airports;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AirportNetwork implements TakeoffDelegate {

    private Set<Airport> airports;

    public AirportNetwork(FileParser parser) {
        Map<Airport, AirplaneTakeoffFleet> airportState;
        airportState = parser.initialState();
        airports = airportState.keySet();
    }


    @Override
    public void onTakeoff(Airplane takeoffComplete) {
        Route nextDestination = takeoffComplete.getRoute();
        String destination0 = nextDestination.getDestination0();
        String destination1 = nextDestination.getDestination1();
    }

    @Override
    public void lastAirport(Airport previousAirport) {

    }
}