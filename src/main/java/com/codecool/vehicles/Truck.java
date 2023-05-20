package com.codecool.vehicles;

import com.codecool.others.Weather;
import com.codecool.util.RandomEvents;

public class Truck extends Vehicle {
    private static final int BROKEN_TRUCK_SPEED = 0;
    private static final int NORMAL_SPEED = 100;
    private static final int MIN_TRUCK_NUMBER = 0;
    private static final int MAX_TRUCK_NUMBER = 1000;

    private static final int BREAKDOWN_CHANCE_PERCENT = 5;

    private static final int LAPS_TO_FIX = 2;

    private TruckState state = TruckState.RUNNING;

    private int breakdownLapsLeft = 0;

    protected Truck() {
        super(NORMAL_SPEED);
    }

    @Override
    public void prepareForLap(Weather weather) {
        // Jeżeli ciężarówka jest zepsuta to stoi czyli prędkość 0
        // w przeciwnym wypadku jedzie z domyślną prędkością
        // Przed okrążeniem musimy sprawdzić status czy cięzarówka się nie zespuła
        actualSpeed = isTruckBroken() ? BROKEN_TRUCK_SPEED : NORMAL_SPEED;
        state = getNextState();
    }

    @Override
    protected String generateName() {
        int truckNumber = RandomEvents.nextNumber(MIN_TRUCK_NUMBER, MAX_TRUCK_NUMBER);
        return Integer.toString(truckNumber);
    }

    private boolean isTruckBroken() {
        return state != TruckState.RUNNING;
    }

    private TruckState getNextState() {
        switch (state) {
            case RUNNING:
                if (RandomEvents.shouldEventHappenWithChance(BREAKDOWN_CHANCE_PERCENT)) {
                    breakdownLapsLeft = LAPS_TO_FIX;
                    return TruckState.BROKEN;
                }
                break;
            case BROKEN:
                // zmniejszyć liczbę okrążeń podczas których jest popsuta
                breakdownLapsLeft--;

                if (breakdownLapsLeft > 0) {
                    return TruckState.BROKEN;
                }

                break;
        }

        return TruckState.RUNNING;
    }
}
