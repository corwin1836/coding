package com.company;

import org.junit.Test;

public class AirplaneLandingFleetTest {
    OneNumberGenerator gen = new OneNumberGenerator();
    Airplane[] fleet = new Airplane[0];
    private RefuelDelegate delegate = new TestRefuelDelegate();

    @Test(expected = IllegalStateException.class)
    public void AirplaneFleet_emptyFleetSize_throwsException() {
        new AirplaneLandingFleet(fleet);
    }

    @Test
    public void removeLeastFuel() {
    }
}