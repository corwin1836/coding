package com.company;

import com.company.interfaces.NumberGenerator;
import com.company.interfaces.RefuelDelegate;

public class LandingPriorityCalculator {

    String uniqueHolder = "AAA-111";

    public Airplane nextToLand(Airplane[] fleet) {
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
//        AirplaneMake make = AirplaneMake.makeGenerator();
//        AirplaneModel model = AirplaneModel.modelGenerator(make);
//        UniqueGenerator uniqueIdentifier = new UniqueGenerator();
//        String identifier = uniqueIdentifier.charGenerator(uniqueHolder);
//        uniqueHolder = identifier;
//        fleet[lastTakeOff] = new Airplane(gen, delegate, make, model, identifier, route, delegate);
//        fleet[lastTakeOff].setRandFuel();
        return currentHighestPriority;
    }
}
