package com.codecool.vehicles;

import com.codecool.util.RandomEvents;

public class Car extends Vehicle {
    private static final int YELLOW_FLAG_SPEED = 75;

    private static final int MIN_SPEED = 80;

    private static final int MAX_SPEED = 110;

    private static final String[] POSSIBLE_NAMES = {
            "Fanfare",
            "Député",
            "Foudre",
            "Début",
            "Renégat",
            "Instinct",
            "Héros",
            "Beauté",
            "Protecteur",
            "Vautour"
    };

    public Car() {
        super(RandomEvents.nextNumber(MIN_SPEED, MAX_SPEED));
    }

    @Override
    protected String generateName() {
        String firstPart = RandomEvents.pickOne(POSSIBLE_NAMES);
        String secondPart = RandomEvents.pickOne(POSSIBLE_NAMES);

        return String.format("%s %s", firstPart, secondPart);
    }

    @Override
    public void prepareForLap(Race race) {
        // jeżeli żółta flaga to 75km/h, w przeciwnym wypadku normal speed
        actualSpeed = race.getIsYellowFlagActive() ? YELLOW_FLAG_SPEED : normalSpeed;
    }
}
