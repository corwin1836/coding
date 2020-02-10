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

    public FileParser(MyFileReader quickReader) throws IOException {
        Gson gson = new Gson();
        trafficControl = gson.fromJson(quickReader.reader("/home/ian/Documents/coding/inputs/planes.json"), TrafficControl.class);
    }

    public Map<String, Airplane[]> buildOutgoing (NumberGenerator generator, RefuelDelegate delegate) {
        Map<String, Airports> airportsMap = trafficControl.getAirports();
        Set<String> keyset = airportsMap.keySet();
        Airports airports;
        Airline[] airlines = new Airline[keyset.size()];
        for(String iterator : keyset) {
            airports = airportsMap.get(iterator);
            airlines = airports.getPlanes();
        }
        Airplane[] airplanes = new Airplane[airlines.length];
        for (int i = 0; i < airlines.length; i += 1) {
            String make = airlines[i].getMake();
            String model = airlines[i].getModel();
            String route = airlines[i].getRoute();
            airplanes[i] = new Airplane(
                    generator,
                    delegate,
                    AirplaneMake.valueOf(make),
                    AirplaneModel.returnProperModel(model),
                    route);
            airplanes[i].setMaxFuel();
        }
        Map<Airport, Airplane[]> airportAndFleet = new HashMap<>();
        int runways = airports.getRunways();
        return ;
    }
}
