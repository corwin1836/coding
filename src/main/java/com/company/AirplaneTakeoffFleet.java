package com.company;

import java.util.ArrayList;
import java.util.Optional;

public class AirplaneTakeoffFleet {

    private RandomNumberGenerator gen = new RandomNumberGenerator();
    private ArrayList<Airplane> fleet;
    private static final int FLEET_CAPACITY = 100;


    public AirplaneTakeoffFleet(RefuelDelegate refuelDelegate) {
        fleet = new ArrayList<>(FLEET_CAPACITY);
        for (int i = 0; i < FLEET_CAPACITY; i++) {
            fleet.add(new Airplane(gen, true, refuelDelegate));
        }
    }

    public Optional<Airplane> firstToTakeoff() {
        Optional<Airplane> currentHighestPriority = Optional.empty();
        for (Airplane airplane : fleet) {
            if (currentHighestPriority.isEmpty()) {
                currentHighestPriority = Optional.of(airplane);
                continue;
            }
            AirplaneMake current = currentHighestPriority.get().getPlaneMake();
            int x = current.priorityMake();
            AirplaneModel currentModel = currentHighestPriority.get().getPlaneModel();
            int a = currentModel.getPassengers();
            AirplaneMake next = airplane.getPlaneMake();
            int y = next.priorityMake();
            AirplaneModel nextModel = airplane.getPlaneModel();
            int b = nextModel.getPassengers();
            if (x < y) {
                currentHighestPriority = Optional.of(airplane);
            } else if (a < b && x == y) {
                currentHighestPriority = Optional.of(airplane);
            }
        }
        return currentHighestPriority;
    }

    public boolean canTakeoffFleet() {
        return !fleet.isEmpty();
    }

    public void addAirplane(Airplane newAirplane) {
        fleet.add(newAirplane);
    }
}