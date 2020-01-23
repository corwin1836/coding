package com.company;

public interface NumberGenerator {
    default int range(int lower, int higher) {
        return (int) range( (double) lower, (double) higher);
    }

    double range(double lower, double higher);
}
