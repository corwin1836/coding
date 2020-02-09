package com.company;

import com.company.models.Airline;
import com.company.models.Airports;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AirportNetwork {

    private Map<Airport, AirlineFleet> network = new HashMap<>();

    public AirportNetwork(Map<String, Airports> airportsMap, AirlineFleet fleet) {
        Set<String> keySet = airportsMap.keySet();
        for (String key : keySet) {
            Airports airports = airportsMap.get(key);
            int runways = airports.getRunways();
            network.put(new Airport(runways), fleet);
        }
    }
}