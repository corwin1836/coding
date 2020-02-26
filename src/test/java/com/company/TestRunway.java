package com.company;

import com.company.interfaces.AirplaneTakeoffDelegate;
import com.company.interfaces.RefuelDelegate;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRunway {
    private OneNumberGenerator gen = new OneNumberGenerator();
    private RefuelDelegate delegate = new TestRefuelDelegate();
    private boolean fuel;
    private AirplaneMake make = AirplaneMake.makeGenerator();
    private AirplaneModel model = AirplaneModel.modelGenerator(make);
    private String identifier = "AAA-111";
    private AirplaneTakeoffDelegate onTakeoff = new TestAirplaneTakeoffDelegate();
    private Route route = new Route();

    @Test
    public void landPlane_inUse_returnsTrue() {
        Airplane a = new Airplane(gen, delegate, make, model, identifier, route, onTakeoff);
        Runway r = new Runway();
        r.landPlane(a);
        assertTrue(r.inUse());
    }

    @Test
    public void takeOffPlane_inUse_returnsTrue() {
        Airplane a = new Airplane(gen, delegate, make, model, identifier, route, onTakeoff);
        Runway r = new Runway();
        r.takeOffPlane(a);
        assertTrue(r.inUse());
    }

    @Test
    public void inUse_afterTakeOffTick_returnsFalse() {
        Airplane a = new Airplane(gen, delegate, make, model, identifier, route, onTakeoff);
        Runway r = new Runway();
        r.takeOffPlane(a);
        r.tick(); // taxi plane to takeoff point
        r.tick(); // lift off!
        assertFalse(r.inUse());
    }

    @Test
    public void inUse_afterLandingTick_returnsFalse() {
        Airplane a = new Airplane(gen, delegate, make, model, identifier, route, onTakeoff);
        Runway r = new Runway();
        r.landPlane(a);
        r.tick();
        assertFalse(r.inUse());
    }
}