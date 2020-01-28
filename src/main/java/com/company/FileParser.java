package com.company;

import com.company.models.Airline;
import com.company.models.Make;
import com.company.models.TrafficControl;
import com.google.gson.Gson;

import java.io.IOException;

public class FileParser{
    private TrafficControl trafficControl;

    public FileParser(MyFileReader quickReader) throws IOException {
        Gson gson = new Gson();
        trafficControl = gson.fromJson(quickReader.reader(), TrafficControl.class);
    }

    public Airplane[] buildIncoming(NumberGenerator generator, RefuelDelegate delegate) {
        Airline[] airlines = trafficControl.getIncoming();
        Airplane[] airplanes = new Airplane[airlines.length];
        for (int i = 0; i < airlines.length; i += 1) {
            Make make = airlines[i].getMake();
            String route = airlines[i].getRoute();
            String makeString = make.getMake();
            String modelString = make.getModel();
            airplanes[i] = new Airplane(
                    generator,
                    delegate,
                    AirplaneMake.valueOf(makeString),
                    AirplaneModel.valueOf(modelString),
                    route);
        }
        return airplanes;
    }
}
