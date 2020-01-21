package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class AirplaneFleetTest {
    OneNumberGenerator gen = new OneNumberGenerator();
    Airplane[] fleet;

    @Test(expected = IllegalStateException.class)
    public void AirplaneFleet_emptyFleetSize_throwsException() {
        new AirplaneFleet(0 );
    }

    @Test
    public void removeLeastFuel() {
    }
}