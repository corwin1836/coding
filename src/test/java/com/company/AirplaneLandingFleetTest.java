package com.company;

import org.junit.Test;

public class AirplaneLandingFleetTest {
    OneNumberGenerator gen = new OneNumberGenerator();
    Airplane[] fleet;
    private RefuelDelegate delegate = new TestRefuelDelegate();

    @Test(expected = IllegalStateException.class)
    public void AirplaneFleet_emptyFleetSize_throwsException() {
        new AirplaneLandingFleet(0, delegate);
    }

    @Test
    public void removeLeastFuel() {
    }
}