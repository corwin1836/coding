package com.company.models;

import com.company.Airplane;
import com.company.AirplaneLandingFleet;

public class TrafficControl {
    private Airline[] incoming;
    private Airline[] outgoing;

    public TrafficControl(Airline[] incoming, Airline[] outgoing) {
        this.incoming = incoming;
        this.outgoing = outgoing;
    }
    public Airline[] getIncoming() {
        return incoming;
    }

    public Airline[] getOutgoing() {
        return outgoing;
    }


}
