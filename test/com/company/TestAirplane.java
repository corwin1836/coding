package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestAirplane {
    OneNumberGenerator gen = new OneNumberGenerator();

    @Test
    public void hasLanded_ReturnsFalse_Immediately() {
        Airplane x = new Airplane(gen, false);
        x.landing();
        assertFalse(x.hasLanded());
    }

    //MethodName_StateUnderTest_ExpectedBehavior//
    @Test
    public void hasTakenOff_immediately_returnsFalse() {
        Airplane x = new Airplane(gen, false);
        x.takeOff();
        assertFalse(x.hasTakenOff());
    }

    @Test
    public void hasLanded_15ticks_returnsTrue() {
        Airplane x = new Airplane(gen, false);
        x.landing();
        x.tick();
        assertTrue(x.hasLanded());
    }

    @Test
    public void hasTakenoff_15ticks_returnsTrue() {
        Airplane x = new Airplane(gen, false);
        x.takeOff();
        x.tick(); //taxi tick
        x.tick(); //takeoff tick
        assertTrue(x.hasTakenOff());
    }

    @Test
    public void getFuel_initially_hasValue() {
        Airplane x = new Airplane(gen, false);
        double fuel = x.getFuel();
        assertNotEquals(fuel, 0.0);
    }
}
    //@Test
//    public
