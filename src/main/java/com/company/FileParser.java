package com.company;

import com.company.models.Airline;
import com.company.models.Airports;
import com.company.models.Make;
import com.company.models.TrafficControl;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

public class FileParser{
    private TrafficControl trafficControl;
    private NumberGenerator gen = new RandomNumberGenerator();
    public FileParser(MyFileReader quickReader) throws IOException {
        Gson gson = new Gson();
        trafficControl = gson.fromJson(quickReader.reader("/home/ian/Documents/coding/inputs/planes.json"), TrafficControl.class);
    }


    public Airports[] buildAirports () {
        Map<String, Airports> airportsMap= trafficControl.getAirports();
        return airportsMap;
    }
    public Airplane[] buildOutgoing (NumberGenerator generator, RefuelDelegate delegate) {
        Map<String, Airports> airportsMap = trafficControl.getAirports();
        Airplane[] airplanes = new Airplane[planes.length];
        for (int i = 0; i < airports.length; i += 1) {
            String model = airports[i].getModel();
            String route = airports[i].getRoute();

            airplanes[i] = new Airplane(
                    generator,
                    delegate,
                    AirplaneMake.valueOf(make),
                    AirplaneModel.returnProperModel(model),
                    route);
            airplanes[i].setMaxFuel();
        }
        return airplanes;
    }
}
