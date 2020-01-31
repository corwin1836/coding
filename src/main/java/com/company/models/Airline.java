package com.company.models;

public class Airline {
    private Make make;
    private String route;

    public Airline(Make make, String route) {
        this.make = make;
        this.route = route;

    }
    public Make getMake() {
        return make;
    }

    public String getRoute() {
        return route;
    }
}
