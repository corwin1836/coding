package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class AirplaneFleetTest {
    OneNumberGenerator gen = new OneNumberGenerator();
    Airplane[] fleet;

    @Test
    public void setFleetPosition__callMultipleMethod_ReturnDifferentPlanes() {
       AirplaneFleet fleet = new AirplaneFleet(2);
       Airplane test = fleet.setFleetPosition();
       Airplane test2 = fleet.setFleetPosition();
       assertNotSame(test, test2);
       
    }

    @Test(expected = IllegalStateException.class)
    public void AirplaneFleet_emptyFleetSize_throwsException() {
        new AirplaneFleet(0);
    }

    @Test
    public void removeLeastFuel() {
    }
}