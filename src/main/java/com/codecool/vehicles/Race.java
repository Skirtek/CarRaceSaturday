package com.codecool.vehicles;

public interface Race {
    void registerRacer(Vehicle vehicle);

    void simulateRace();

    boolean getIsYellowFlagActive();

    boolean isRaining();

    void printRaceResults();
}
