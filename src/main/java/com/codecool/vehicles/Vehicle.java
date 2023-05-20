package com.codecool.vehicles;

/**
 * Base class of all types of the vehicles.
 */
public abstract class Vehicle {
    /**
     * The name of the vehicle
     */
    private final String name;

    /**
     * Speed with normal without any additional conditions on track and weather.
     */
    private int normalSpeed;

    protected int actualSpeed;

    private int distanceTraveled;

    protected Vehicle(int normalSpeed) {
        this.name = generateName();
        this.normalSpeed = normalSpeed;
    }

    protected abstract String generateName();

    public abstract void prepareForLap();

    public void moveForAnHour() {
        distanceTraveled += actualSpeed;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName());

        stringBuilder.append(" with name ");
        stringBuilder.append(name);
        stringBuilder.append(" traveled distance ");
        stringBuilder.append(distanceTraveled);
        stringBuilder.append("km");

        return stringBuilder.toString();
    }
}
