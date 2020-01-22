package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class AirplaneFleetTest {
    OneNumberGenerator gen = new OneNumberGenerator();
    Airplane[] fleet;
    private RefuelDelegate delegate = new TestRefuelDelegate();

    @Test(expected = IllegalStateException.class)
    public void AirplaneFleet_emptyFleetSize_throwsException() {
        new AirplaneFleet(0, delegate);
    }

    @Test
    public void removeLeastFuel() {
    }
}