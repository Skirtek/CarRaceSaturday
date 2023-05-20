package com.codecool.vehicles;

import com.codecool.others.Weather;
import com.codecool.util.RandomEvents;

public class Motorcycle extends Vehicle {
    private static int MOTO_NUMBER = 1;

    private static final int NORMAL_SPEED = 100;

    private static final int MIN_SLOW_DOWN_VALUE = 5;

    private static final int MAX_SLOW_DOWN_VALUE = 50;

    /**
     * Create a vehicle with generated name and given speed
     */
    public Motorcycle() {
        super(NORMAL_SPEED);
    }

    @Override
    protected String generateName() {
        return "Motorcycle " + MOTO_NUMBER++;
    }

    @Override
    public void prepareForLap(Weather weather) {
        actualSpeed = normalSpeed;

        if (weather.isRaining()) {
            int slowDown = RandomEvents.nextNumber(MIN_SLOW_DOWN_VALUE, MAX_SLOW_DOWN_VALUE);
            actualSpeed -= slowDown;
        }
    }
}
