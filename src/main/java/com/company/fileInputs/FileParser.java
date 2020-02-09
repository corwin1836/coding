package com.company.fileInputs;

import com.company.Airplane;
import com.company.AirplaneMake;
import com.company.AirplaneModel;
import com.company.RandomNumberGenerator;
import com.company.interfaces.NumberGenerator;
import com.company.interfaces.RefuelDelegate;
import com.company.models.Airline;
import com.company.models.Airports;
import com.company.models.TrafficControl;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class FileParser{
    private TrafficControl trafficControl;
    private NumberGenerator gen = new RandomNumberGenerator();
    public FileParser(MyFileReader quickReader) throws IOException {
        Gson gson = new Gson();
        trafficControl = gson.fromJson(quickReader.reader("/home/ian/Documents/coding/inputs/planes.json"), TrafficControl.class);
    }

    public Airplane[] buildOutgoing (NumberGenerator generator, RefuelDelegate delegate) {
        Map<String, Airports> airportsMap = trafficControl.getAirports();
        Set<String> keyset = airportsMap.keySet();
        for(String iterator : keyset) {
            Airports airports = airportsMap.get(iterator);
            Airline[] airlines = airports.getPlanes();
        }
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
