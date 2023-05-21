package com.codecool;

import com.codecool.vehicles.*;

public class Main {
    private static final int NUMBER_OF_EACH_TYPE_RACERS = 10;

    public static void main(String[] args) {
        Race race = new RaceImpl();

        for (int i = 0; i < NUMBER_OF_EACH_TYPE_RACERS; i++) {
            race.registerRacer(new Car());
            race.registerRacer(new Truck());
            race.registerRacer(new Motorcycle());
        }

        race.simulateRace();
        race.printRaceResults();
    }
}