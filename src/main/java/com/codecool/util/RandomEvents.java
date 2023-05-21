package com.codecool.util;

import java.util.Random;

public class RandomEvents {
    private static final Random RANDOM = new Random();

    public static int nextNumber(int range) {
        return RANDOM.nextInt(range);
    }

    public static int nextNumber(int start, int end) {
        return RANDOM.nextInt(start, end + 1);
    }

    public static boolean shouldEventHappenWithChance(int chance) {
        return nextNumber(100) < chance;
    }

    /**
     * Returns random member of input array
     *
     * @param options Input array
     * @return Random member of input array
     */
    public static String pickOne(String[] options) {
        if (options == null || options.length == 0) {
            String msg = "Options should be non-empty array";
            throw new IllegalArgumentException(msg);
        }

        // next number gets random number between 0 and range - 1, so it is safe for array
        return options[nextNumber(options.length)];
    }
}
