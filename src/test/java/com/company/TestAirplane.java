package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAirplane {

    private OneNumberGenerator gen = new OneNumberGenerator();
    private RefuelDelegate delegate = new TestRefuelDelegate();
    private AirplaneMake make = AirplaneMake.makeGenerator();
    private AirplaneModel model = AirplaneModel.modelGenerator(make);
    String identifier = "AAA-111";

    @Test
    public void hasLanded_ReturnsFalse_Immediately() {
        Airplane x = new Airplane(gen, delegate, make, model, identifier);
        x.landing();
        assertFalse(x.hasLanded());
    }

    //MethodName_StateUnderTest_ExpectedBehavior//
    @Test
    public void hasTakenOff_immediately_returnsFalse() {
        Airplane x = new Airplane(gen, delegate, make, model, identifier);
        x.takeOff();
        assertFalse(x.hasTakenOff());
    }

    @Test
    public void hasLanded_1ticks_returnsTrue() {
        Airplane x = new Airplane(gen, delegate, make, model, identifier);
        x.landing();
        x.tick();
        assertTrue(x.hasLanded());
    }

    @Test
    public void hasTakenoff_15ticks_returnsTrue() {
        Airplane x = new Airplane(gen, delegate, make, model, identifier);
        x.takeOff();
        x.tick(); //taxi tick
        x.tick(); //takeoff tick
        assertTrue(x.hasTakenOff());
    }

    @Test
    public void getFuel_initially_hasValue() {
        Airplane x = new Airplane(gen, delegate, make, model, identifier);
        double fuel = x.getFuel();
        assertNotEquals(fuel, 0.0);
    }
}
    //@Test
//    public
