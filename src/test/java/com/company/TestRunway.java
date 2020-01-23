package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestRunway {
    private OneNumberGenerator gen = new OneNumberGenerator();
    private RefuelDelegate delegate = new TestRefuelDelegate();
    private boolean fuel;

    @Test
    public void landPlane_inUse_returnsTrue() {
        Airplane a = new Airplane(gen, fuel, delegate);
        Runway r = new Runway();
        r.landPlane(a);
        assertTrue(r.inUse());
    }

    @Test
    public void takeOffPlane_inUse_returnsTrue() {
        Airplane a = new Airplane(gen, fuel, delegate);
        Runway r = new Runway();
        r.takeOffPlane(a);
        assertTrue(r.inUse());
    }

    @Test
    public void inUse_afterTakeOffTick_returnsFalse() {
        Airplane a = new Airplane(gen, fuel, delegate);
        Runway r = new Runway();
        r.takeOffPlane(a);
        r.tick(); // taxi plane to takeoff point
        r.tick(); // lift off!
        assertFalse(r.inUse());
    }

    @Test
    public void inUse_afterLandingTick_returnsFalse() {
        Airplane a = new Airplane(gen, fuel, delegate);
        Runway r = new Runway();
        r.landPlane(a);
        r.tick();
        assertFalse(r.inUse());
    }
}