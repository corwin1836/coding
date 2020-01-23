package com.company;

public class Runway {
    private Airplane currentPlane;
    private boolean isTakingOff;

    public boolean inUse() {
        return currentPlane != null;
    }

    public void tick() {
        if (currentPlane != null) {
            currentPlane.tick();
            if (isTakingOff && currentPlane.hasTakenOff()) {
                currentPlane = null;
            }
            if (!isTakingOff && currentPlane.hasLanded()) {
                currentPlane = null;
            }
        }
    }

    public void landPlane(Airplane x) {
        this.currentPlane = x;
        x.landing();
        isTakingOff = false;
    }

    public void takeOffPlane(Airplane x) {
        this.currentPlane = x;
        x.takeOff();
        isTakingOff = true;
    }


}


