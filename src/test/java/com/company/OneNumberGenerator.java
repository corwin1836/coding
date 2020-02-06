package com.company;

import com.company.interfaces.NumberGenerator;

public class OneNumberGenerator implements NumberGenerator {
    @Override
    public double range(double lower, double higher) {
        return 1.0;
    }
}
