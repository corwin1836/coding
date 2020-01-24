package com.company;

public class AirplaneLandingFleet {

    private RandomNumberGenerator gen = new RandomNumberGenerator();
    private Airplane[] fleet;
    private RefuelDelegate delegate;

    public AirplaneLandingFleet(int fleetSize, RefuelDelegate delegate) {
        if (fleetSize < 1)
            throw new IllegalStateException();
        fleet = new Airplane[fleetSize];
        this.delegate = delegate;
        for (int i = 0; i < fleet.length; i++) {
            Airplane x = new Airplane(gen, false, delegate);
            fleet[i] = x;
        }
    }

    public Airplane nextToLand() {
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
