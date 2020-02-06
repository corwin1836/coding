package com.company;

import com.company.interfaces.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public double range(double lower, double higher) {
        return Math.random() * (higher - lower) +lower;
    }
}
