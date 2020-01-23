package com.company;

import java.util.ArrayList;

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

    public Airplane firstToTakeoff() {
        Airplane currentHighestPriority = fleet.get(0);
        for (int i = 0; i < fleet.size(); i += 1) {
            AirplaneMake current = currentHighestPriority.getPlaneMake();
            int x = current.priorityMake(currentHighestPriority);
            AirplaneModel currentModel = currentHighestPriority.getPlaneModel();
            int a = currentModel.getPassengers();
            Airplane nextHighestPriority = fleet.get(i);
            AirplaneMake next = nextHighestPriority.getPlaneMake();
            int y = next.priorityMake(nextHighestPriority);
            AirplaneModel nextModel = nextHighestPriority.getPlaneModel();
            int b = nextModel.getPassengers();
            if (x < y) {
                currentHighestPriority = nextHighestPriority;
            } else

            }




        }

    }

    public boolean canTakeoffFleet() {
        return !fleet.isEmpty();
    }

    public Airplane getNextTakeoff() {
        Airplane ret =fleet.get(0);
        return ret;
    }

    public void addAirplane(Airplane newAirplane) {
        fleet.add(newAirplane);
    }
}