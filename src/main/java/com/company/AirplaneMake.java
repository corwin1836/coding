package com.company;

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

    public int priorityMake(Airplane x) {
        if (x.getPlaneMake() == AirplaneMake.Noedel) {
            return 3;
        }
        if (x.getPlaneMake() == AirplaneMake.Martin) {
            return 2;
        }
        if (x.getPlaneMake() == AirplaneMake.Bárðarbunga) {
            return 2;
        } else {
            return 1;
        }
    }
}
