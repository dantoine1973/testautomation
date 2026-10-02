package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import com.healthycoderapp.BMICalculator;
import com.healthycoderapp.Coder;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

public class DietPlannerTest {
    private DietPlanner dietPlanner;

    @BeforeEach
    void setup() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void teardown() {
        System.out.println("Unit test completed.");
    }
    @Test
    void shouldReturnCorrectDietPlan_WhenCorrectCoderIsGiven() {
        // given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expectedDietPlan = new DietPlan(2202, 110, 73, 275);

        // when
        DietPlan actualDietPlan = dietPlanner.calculateDiet(coder);

        // then
        assertAll(
                () -> assertEquals(expectedDietPlan.getCalories(), actualDietPlan.getCalories()),
                () -> assertEquals(expectedDietPlan.getProtein(), actualDietPlan.getProtein()),
                () -> assertEquals(expectedDietPlan.getFat(), actualDietPlan.getFat()),
                () -> assertEquals(expectedDietPlan.getCarbohydrate(), actualDietPlan.getCarbohydrate())
        );
    }
}
