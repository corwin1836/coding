package com.company;

import com.sun.tools.attach.AgentInitializationException;
import org.junit.Test;
import org.junit.internal.runners.statements.RunAfters;

import static org.junit.Assert.*;

public class TestRunway {
    OneNumberGenerator gen = new OneNumberGenerator();

    @Test
    public void landPlane_inUse_returnsTrue() {
        Airplane a = new Airplane(gen);
        Runway r = new Runway();
        r.landPlane(a);
        assertTrue(r.inUse());
    }

    @Test
    public void takeOffPlane_inUse_returnsTrue() {
        Airplane a = new Airplane(gen);
        Runway r = new Runway();
        r.takeOffPlane(a);
        assertTrue(r.inUse());
    }

    @Test
    public void inUse_afterTakeOffTick_returnsFalse() {
        Airplane a = new Airplane(gen);
        Runway r = new Runway();
        r.takeOffPlane(a);
        r.tick(); // taxi plane to takeoff point
        r.tick(); // lift off!
        assertFalse(r.inUse());
    }

    @Test
    public void inUse_afterLandingTick_returnsFalse() {
        Airplane a = new Airplane(gen);
        Runway r = new Runway();
        r.landPlane(a);
        r.tick();
        assertFalse(r.inUse());
    }
}