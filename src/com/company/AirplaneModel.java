package com.company;

public enum AirplaneModel {

    A320(200, 120),
    A5000(215, 130),
    z416(112, 12),
    A9k(556, 362),
    Halló(326, 200),
    Ostur(100, 10);

    private int fuel;
    private int passengers;




    AirplaneModel(int fuel, int passengers) {
        this.fuel = fuel;
        this.passengers = passengers;
    }

    public static AirplaneModel modelGenerator(AirplaneMake make) {
        RandomNumberGenerator gen = new RandomNumberGenerator();
        switch (make) {
            case Noedel:
                int noedelRange = gen.range(0, 1);
                if (noedelRange == 0) {
                    return A320;
                } else {
                    return A5000;
                }
            case Trebek:
                return z416;
            case Martin:
                return A9k;
            case Bárðarbunga:
                int bBárðarbungaRange = gen.range(0, 1);
                if (bBárðarbungaRange == 0) {
                    return Halló;
                } else {
                    return Ostur;
                }
            default: throw new IllegalStateException();
        }
    }

    public int getFuel() {
        return fuel;
    }

    public String toString() {
        switch (this) {
            case A320:
                return "320";
            case A5000:
                return "5000";
            case z416:
                return "z416";
            case A9k:
                return "9k";
            case Halló:
                return "Halló";
            case Ostur:
                return "Ostur";
            default:
                throw new IllegalStateException("Invalid model given to toString.");
        }
    }

    public int getPassengers() {
        return passengers;
    }
}
