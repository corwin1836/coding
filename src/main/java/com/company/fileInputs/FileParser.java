package com.company.fileInputs;

import com.company.*;
import com.company.interfaces.NumberGenerator;
import com.company.interfaces.RefuelDelegate;
import com.company.models.Airline;
import com.company.models.Airports;
import com.company.models.TrafficControl;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileParser{
    private TrafficControl trafficControl;
    private NumberGenerator gen = new RandomNumberGenerator();
    private RefuelDelegate delegate;

    public FileParser(MyFileReader quickReader) throws IOException {
        Gson gson = new Gson();
        trafficControl = gson.fromJson(quickReader.reader("/home/ian/Documents/coding/inputs/planes.json"), TrafficControl.class);
    }

    public Map<String, Airplane[]> buildOutgoing () {
        Map<String, Airports> airportsMap = trafficControl.getAirports();
        Set<String> keyset = airportsMap.keySet();
        Airports airports;
        Airline[] airlines = new Airline[keyset.size()];
        for(String iterator : keyset) {
            airports = airportsMap.get(iterator);
            airlines = airports.getPlanes();
            this.nonDomainAilineToAirplanes(gen, delegate)
        }
        Airplane[] airplanes = new Airplane[airlines.length];

        Map<Airport, Airplane[]> airportAndFleet = new HashMap<>();
        int runways = airports.getRunways();
        return ;
    }

    private Airplane nonDomainAirlineToAirplane(Airline airline) {
        String make = airline.getMake();
        String model = airline.getModel();
        String uniqueIdentifier = airline.getRoute();
        return new Airplane(
                gen,
                delegate,
                AirplaneMake.valueOf(make),
                AirplaneModel.returnProperModel(model),
                uniqueIdentifier);
    }

    private Airport airportsToAirport(Airports airports) {
        int runways = airports.getRunways();
        Airline[] airplanes = airports.getPlanes();
        Airplane[] airplane = new Airplane[airplanes.length];
        for (int i = 0; i < airplanes.length; i += 1) {
             airplane[i] = nonDomainAirlineToAirplane(airplanes[i]);
        }

    }
}
