package com.company;

public class RandomNumberGenerator implements NumberGenerator{

    @Override
    public int range(int lower, int higher) {
        return (int) (Math.random() * (higher - lower) +lower);
    }
}
