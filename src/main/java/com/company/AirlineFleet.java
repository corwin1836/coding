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


    public AirlineFleet(Map<String, Airports> airportDump, RefuelDelegate delegate) {
        Set<String> airportName = airportDump.keySet();
        for (String key : airportName) {
            Airports airports = airportDump.get(key);
            Airline[] airline = airports.getPlanes();
            for (int i = 0; i < airline.length; i++) {
                String make = airline[i].getMake();
                String model = airline[i].getModel();
                String route = airline[i].getRoute();
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
