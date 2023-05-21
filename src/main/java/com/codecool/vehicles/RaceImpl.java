package com.codecool.vehicles;

import com.codecool.others.Weather;

import java.util.ArrayList;
import java.util.List;

public class RaceImpl implements Race {
    private static final int NUMBER_OF_LAPS = 50;

    private final List<Vehicle> vehicles = new ArrayList<>();

    private final Weather weather = new Weather();

    private boolean isYellowFlagActive;

    public boolean getIsYellowFlagActive() {
        return isYellowFlagActive;
    }

    @Override
    public boolean isRaining() {
        return weather.isRaining();
    }

    @Override
    public void registerRacer(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public void simulateRace() {
        for (int i = 0; i < NUMBER_OF_LAPS; i++) {
            vehicles.forEach(vehicle -> {
                vehicle.prepareForLap(this);
                vehicle.moveForAnHour();
            });

            weather.advance();
            isYellowFlagActive = checkIsYellowFlagActive();
        }
    }

    @Override
    public void printRaceResults() {
        System.out.println("Race results:");
        vehicles.forEach(System.out::println);
    }

    private boolean checkIsYellowFlagActive() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck truck && truck.isTruckBroken()) {
                return true;
            }
        }

        return false;
    }
}
