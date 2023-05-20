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
}
