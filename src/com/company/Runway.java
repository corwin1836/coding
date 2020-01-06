package com.company;

public class Runway {
    private boolean status = false;

    public boolean inUse() {
        return status;
    }

    public void setInUse() {
        status = true;
    }

    public void setAvailable() {
        status = false;
    }
}
