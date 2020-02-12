package com.company;

import com.company.interfaces.NumberGenerator;
import com.company.interfaces.RefuelDelegate;
import com.company.interfaces.TakeoffDelegate;
import com.company.interfaces.Tickable;

public class Airplane implements Tickable {

    private static int planeDesignation = 0;
    private int designation;
    private boolean off;
    private double fuel;
    private int landingTime;
    private int takeoffTime;
    private int taxiTime;
    private NumberGenerator generator;
    private AirplaneModel model;
    private AirplaneMake make;
    private String uniqueIdentifier;
    private int refuelingTime;
    private RefuelDelegate refueled;
    private Route route;
    private TakeoffDelegate takenOff;


    public Airplane(
            NumberGenerator generator,
            RefuelDelegate refueled,
            AirplaneMake make,
            AirplaneModel model,
            String uniqueIdentifier,
            Route route,
            TakeoffDelegate takenOff
    ) {
        planeDesignation++;
        designation = planeDesignation;
        this.make = make;
        this.model = model;
        this.uniqueIdentifier = uniqueIdentifier;
        this.generator = generator;
        this.refueled = refueled;
        this.route = route;
        this.takenOff = takenOff;
    }

    public void takeOff() {
        taxiTime = generator.range(3, 5);
        takeoffTime = generator.range(5, 15);
        off = false;
    }

    public void landing() {
        landingTime = generator.range(5, 15);
        refuelingTime = generator.range(3,5);
        off = true;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        double maximum = model.getFuel();
        if (fuel > maximum || fuel < 0) {
            throw new IllegalArgumentException();
        }
        this.fuel = fuel;
    }

    public void setMaxFuel() {
        double fuel = getPlaneModel().getFuel();
        setFuel(fuel);
    }

    public void setRandFuel() {
        double maxFuel = getPlaneModel().getFuel();
        double fuel = generator.range(0, maxFuel);
        setFuel(fuel);
    }

    public boolean hasTakenOff() {
        return off;
    }

    public boolean hasLanded() {
        return !off;
    }

    public AirplaneMake getPlaneMake() {
        return make;
    }

    public AirplaneModel getPlaneModel() {
        return model;
    }

    public void tick() {
        if (taxiTime > 0) {
            taxiTime--;
            return;
        }
        if (takeoffTime > 0) {
            takeoffTime--;
            if (takeoffTime == 0) {
                off = true;
                takenOff.onTakeoff(this);
                System.out.println(designation +" "+ uniqueIdentifier + " " + make + " " + model +" "+ "Has taken off!");
            }
        }
        if (landingTime > 0) {
            landingTime--;
            if (landingTime == 0) {
                off = false;
                System.out.println(designation +" "+ uniqueIdentifier +" "+ make + " " + model +" "+ "Has landed! YAY!");
            }
        }
        if (landingTime == 0 && refuelingTime > 0) {
            refuelingTime -= 1;
            if (refuelingTime == 0) {
                refueled.onRefuelCompleted(this);
                setMaxFuel();
            }
        }
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }
}
