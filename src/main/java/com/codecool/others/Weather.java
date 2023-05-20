package com.codecool.others;

import com.codecool.util.RandomEvents;

public class Weather {
    private static final int CHANCE_OF_RAIN_PERCENT = 30;

    private boolean isRaining = false;

    public Weather() {
        advance();
    }

    public boolean isRaining() {
        return isRaining;
    }

    public void advance() {
        isRaining = RandomEvents.shouldEventHappenWithChance(CHANCE_OF_RAIN_PERCENT);
    }
}
