package com.company;

import com.company.models.Make;

public enum AirplaneMake {
    Noedel, Trebek, Martin, Bárðarbunga;

    public static AirplaneMake makeGenerator() {
        RandomNumberGenerator gen = new RandomNumberGenerator();
        int newMake = gen.range(0, 3);
        switch (newMake) {
            case 0:
                return AirplaneMake.Noedel;
            case 1:
                return AirplaneMake.Trebek;
            case 2:
                return AirplaneMake.Martin;
            case 3:
                return AirplaneMake.Bárðarbunga;
            default:
                throw new IllegalStateException();
        }
    }

    public int priorityMake() {
        switch (this) {
            case Noedel:
                return 3;
            case Trebek:
                return 1;
            default:
                return 2;
        }
    }
}
