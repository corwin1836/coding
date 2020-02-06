package com.company;

import com.company.interfaces.NumberGenerator;
import com.company.interfaces.RefuelDelegate;
import com.company.models.Airline;
import com.company.models.Airports;

import java.util.Map;
import java.util.Set;

public class AirlineFleet {

    Airplane[] fleet;
    NumberGenerator gen = new RandomNumberGenerator();
    RefuelDelegate delegate;


    public AirlineFleet(Map<String, Airports> airportDump) {
        Set<String> airportName = airportDump.keySet();
        for (String key : airportName) {
            Airports airports = airportDump.get(key);
            Airline[] airline = airports.getPlanes();
            for (int i = 0; i < airline.length; i++) {
                String make = bob.getMake();
                String model = bob.getModel();
                String route = bob.getRoute();
                fleet[i] = new Airplane(
                        gen,
                        delegate,
                        AirplaneMake.valueOf(make),
                        AirplaneModel.returnProperModel(model),
                        route);
            }
        }

    }
}
