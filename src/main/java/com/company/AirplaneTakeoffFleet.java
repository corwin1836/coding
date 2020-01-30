package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class AirplaneTakeoffFleet {

    private ArrayList<Airplane> fleet;


    public AirplaneTakeoffFleet(Airplane[] takeoffList) {
        fleet = new ArrayList<>(takeoffList.length);
        Collections.addAll(fleet, takeoffList);
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

    public void addAirplane(Airplane newAirplane) {
        fleet.add(newAirplane);
    }
}