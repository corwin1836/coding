package com.company.models;

import com.company.Airplane;
import com.company.AirplaneLandingFleet;

import java.util.Map;

public class TrafficControl {
    private Map<String, RouteDesignator> routes;
    private Map<String, Airports> airports;


    public Map<String, Airports> getAirports() {
        return airports;
    }

    public Map<String, RouteDesignator> getRoutes() {
        return routes;
    }

}
