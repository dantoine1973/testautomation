package com.healthycoderapp;

public class ActivityCalculator {

    private static final int WORKOUT_DURATION_MIN = 45;

    public static String rateActivityLevel(int weeklyCardioMin, int weeklyWorkoutSessions) {
        if (weeklyCardioMin < 0 || weeklyWorkoutSessions < 0) {
            throw new IllegalArgumentException("Weekly cardio minutes and workout sessions must be non-negative.");
        }

        int totalMinutes = weeklyCardioMin + (weeklyWorkoutSessions * WORKOUT_DURATION_MIN);

        double averageMinutesPerDay = totalMinutes / 7.0;

        if (averageMinutesPerDay >= 40) {
            return "Highly Active";
        } else if (averageMinutesPerDay >= 20 && averageMinutesPerDay < 40) {
            return "Moderately Active";
        } else {
            return "Low Activity";
        }
    }
}
