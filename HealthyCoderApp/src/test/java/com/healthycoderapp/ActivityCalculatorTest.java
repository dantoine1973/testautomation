package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class ActivityCalculatorTest {

    @Test
    void shouldReturnHighlyActive_WhenCardio150AndWorkout4() {
        String activityLevel = ActivityCalculator.rateActivityLevel(150, 4);
        assertEquals("Highly Active", activityLevel);
    }

    @Test
    void shouldReturnModeratelyActive_WhenCardio75AndWorkout2() {
        String activityLevel = ActivityCalculator.rateActivityLevel(75, 2);
        assertEquals("Moderately Active", activityLevel);
    }

    @Test
    void shouldReturnLowActivity_WhenCardioLessThan75AndWorkoutLessThan1() {
        String activityLevel = ActivityCalculator.rateActivityLevel(50, 0);
        assertEquals("Low Activity", activityLevel);
    }

    @Test
    void shouldThrowIllegalArgumentException_WhenNegativeCardio() {
        assertThrows(IllegalArgumentException.class, () -> {
            ActivityCalculator.rateActivityLevel(-10, 1);
        });
    }

    @Test
    void shouldThrowIllegalArgumentException_WhenNegativeWorkout() {
        assertThrows(IllegalArgumentException.class, () -> {
            ActivityCalculator.rateActivityLevel(100, -1);
        });
    }
}
