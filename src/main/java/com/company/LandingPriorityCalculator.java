package com.company;

public class LandingPriorityCalculator {


    public Airplane nextToLand(Airplane[] fleet, NumberGenerator gen, RefuelDelegate delegate) {
        Airplane currentHighestPriority = fleet[0];
        int lastTakeOff = 0;
        for (int i = 0; i < fleet.length; i++) {
            Airplane airplane = fleet[i];
            AirplaneMake current = currentHighestPriority.getPlaneMake();
            int x = current.priorityMake();
            AirplaneModel currentModel = currentHighestPriority.getPlaneModel();
            int a = currentModel.getPassengers();
            AirplaneMake next = airplane.getPlaneMake();
            int y = next.priorityMake();
            AirplaneModel nextModel = airplane.getPlaneModel();
            int b = nextModel.getPassengers();

            if (airplane.getFuel() <= currentHighestPriority.getFuel()) {
                currentHighestPriority = airplane;
                lastTakeOff = i;
            } else if (x < y) {
                currentHighestPriority = airplane;
                lastTakeOff = i;
            } else if (a < b && x == y) {
                currentHighestPriority = airplane;
                lastTakeOff = i;
            }
        }
        fleet[lastTakeOff] = new Airplane(gen, false, delegate);
        return currentHighestPriority;
    }
}
