package com.company;

public class Airplane implements Tickable {

    private static int planeDesignation = 0;
    private int designation;
    private boolean off;
    private double fuel;
    private int landingTime;
    private int takeoffTime;
    private int taxiTime;
    private NumberGenerator generator;
    private String identifier;
    private UniqueGenerator unique = new UniqueGenerator();
    private static String lastIdentifier = "AAA-111";
    private AirplaneModel model;
    private AirplaneMake make;
    private int refuelingTime;
    private RefuelDelegate refueled;


    public Airplane(NumberGenerator generator, boolean fullFuel, RefuelDelegate refueled) {
        planeDesignation++;
        designation = planeDesignation;
        AirplaneMake make = AirplaneMake.makeGenerator();
        AirplaneModel model = AirplaneModel.modelGenerator(make);
        this.model = model;
        this.make = make;
        this.generator = generator;
        this.refueled = refueled;
        if (fullFuel) {
            fuel = model.getFuel();
        } else {
            fuel = generator.range(0.0, model.getFuel());
        }
    }

    public void takeOff() {
        taxiTime = generator.range(3, 5);
        takeoffTime = generator.range(5, 15);
        off = false;
        try {
            identifier = unique.charGenerator(lastIdentifier);
        } catch (Exception blargh) {
            blargh.printStackTrace();
        }
        lastIdentifier = identifier;

    }

    public void landing() {
        landingTime = generator.range(5, 15);
        refuelingTime = generator.range(3,5);
        off = true;
        try {
            identifier = unique.charGenerator(lastIdentifier);
        } catch (Exception blargh) {
            blargh.printStackTrace();
        }
        lastIdentifier = identifier;
    }

    public double getFuel() {
        return fuel;
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
                System.out.println(designation +" "+ identifier + " " + make + " " + model +" "+ "Has taken off!");
            }
        }
        if (landingTime > 0) {
            landingTime--;
            if (landingTime == 0) {
                off = false;
                System.out.println(designation +" "+ identifier +" "+ make + " " + model +" "+ "Has landed! YAY!");
            }
        }
        if (landingTime == 0 && refuelingTime >0) {
            refuelingTime -= 1;
            if (refuelingTime == 0) {
                refueled.onRefuelCompleted(this);
                fuel = model.getFuel();
            }
        }
    }
}
