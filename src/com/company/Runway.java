package com.company;

public class Runway {
    public Airplane x;
    private boolean isTakingOff;

    public boolean inUse() {
        return x != null;
    }

    public void tick() {
        if (x != null) {
            x.tick();
            if (isTakingOff && x.hasTakenOff()) {
                x = null;
            }
            if (!isTakingOff && x.hasLanded()) {
                x = null;
            }
        }
    }

    public void landPlane(Airplane x) {
        this.x = x;
        x.landing();
        isTakingOff = false;
    }

    public void takeOffPlane(Airplane x) {
        this.x = x;
        x.takeOff();
        isTakingOff = true;
    }
}


