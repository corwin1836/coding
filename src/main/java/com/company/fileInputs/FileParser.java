package com.company.fileInputs;

import com.company.*;
import com.company.interfaces.NumberGenerator;
import com.company.interfaces.RefuelDelegate;
import com.company.models.Airline;
import com.company.models.Airports;
import com.company.models.RouteDesignator;
import com.company.models.TrafficControl;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileParser {
    private TrafficControl trafficControl;
    private NumberGenerator gen = new RandomNumberGenerator();
    private RefuelDelegate delegate;

    public FileParser(MyFileReader quickReader) throws IOException {
        Gson gson = new Gson();
        trafficControl = gson.fromJson(quickReader.reader("/home/ian/Documents/coding/inputs/planes.json"), TrafficControl.class);
    }

    public Map<Airport, AirplaneTakeoffFleet> initialState() {
        Map<String, Airports> airportsMap = trafficControl.getAirports();
        Map<String, RouteDesignator> routeMap = trafficControl.getRoutes();
        Set<Map.Entry<String, Airports>> airports = airportsMap.entrySet();


        for (Map.Entry<String, Airports> next : airports) {
            Airports currentAirports = next.getValue();
            Airport newAirport = airportsToAirport(currentAirports);
            Airline[] newAirline = currentAirports.getPlanes();
            for(int i = 0; i < newAirline.length; i++) {
                String airlineRoute = newAirline[i].getRoute();
                RouteDesignator designatorRoute = routeMap.get(airlineRoute);
                Airplane newAirplane = nonDomainAirlineToAirplane(newAirline[i], designatorRoute);
            }

        }

        Airports airports;
        Airline[] airlines = new Airline[keyset.size()];
        for (String iterator : keyset) {
            airports = airportsMap.get(iterator);
            airlines = airports.getPlanes();
            this.nonDomainAirlineToAirplane();
        }
        Airplane[] airplanes = new Airplane[airlines.length];

        Map<Airport, Airplane[]> airportAndFleet = new HashMap<>();
        int runways = airports.getRunways();
        return;
    }

    private Airplane nonDomainAirlineToAirplane(Airline airline, RouteDesignator route) {
        String make = airline.getMake();
        String model = airline.getModel();
        String uniqueIdentifier = airline.getRoute();
        Route planeRoute = routesToDestinations(route);
        return new Airplane(
                gen,
                delegate,
                AirplaneMake.valueOf(make),
                AirplaneModel.returnProperModel(model),
                uniqueIdentifier,
                planeRoute);
    }

    private Airport airportsToAirport(Airports airports) {
        int runways = airports.getRunways();
        return new Airport(runways);
    }

    private Route routesToDestinations(RouteDesignator routes) {
       String zero = routes.getDestination1();
       String one = routes.getDestination2();
       Route route = new Route();
       route.setDestination0(zero);
       route.setDestination1(one);
       return route;
    }

}
