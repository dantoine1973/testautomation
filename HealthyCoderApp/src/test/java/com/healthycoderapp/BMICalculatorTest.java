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

public class BMICalculatorTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all unit tests");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Unit test started.");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("Unit test completed.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all unit tests");
    }

    /*
     * @Test
     * void shouldFail_WhenNotYetImplemented() {
     * fail("Not yet implemented");
     * }
     */

    /*
     * @Test
     * void shouldPass_WhenAssertTrue() {
     * assertTrue(true);
     * }
     */

    @Test
    void shouldReturnTrue_WhenDietIsRecommended() {

        // given
        double weight = 89.0;
        double height = 1.72;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then
        assertTrue(recommended);
    }

    @Test
    void shouldReturnFalse_WhenDietIsNotRecommended() {

        // given
        double weight = 70.0;
        double height = 1.75;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then
        assertFalse(recommended);
    }

    @Test
    void shouldThrowArithmeticException_WhenHeightIsZero() {

        // given
        double weight = 70.0;
        double height = 0.0;

        // when
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        // then
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void shouldReturnCoderWithWorstBMI_WhenCoderListIsNotEmpty() {

        // given
        Coder coder1 = new Coder(1.80, 60.0);
        Coder coder2 = new Coder(1.82, 98.0);
        Coder coder3 = new Coder(1.82, 64.7);

        List<Coder> coders = List.of(coder1, coder2, coder3);

        // when
        Coder worstBMICoder = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertAll(
                () -> assertEquals(1.82, worstBMICoder.getHeight(), 0.01),
                () -> assertEquals(98.0, worstBMICoder.getWeight(), 0.01));

    }

    @Test
    void shouldReturnNullWorstBMICoder_WhenCoderListIsEmpty() {

        // given
        List<Coder> coders = List.of();

        // when
        Coder worstBMICoder = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertNull(worstBMICoder);
    }

    @Test
    void shouldReturnCorrectBMIScoreArray_WhenCoderListIsNotEmpty() {

        // given
        Coder coder1 = new Coder(1.80, 60.0);
        Coder coder2 = new Coder(1.82, 98.0);
        Coder coder3 = new Coder(1.82, 64.7);

        List<Coder> coders = List.of(coder1, coder2, coder3);
        double[] expected = { 18.52, 29.59, 19.53 };

        // when
        double[] bmiScores = BMICalculator.getBMIScores(coders);

        // then
        assertArrayEquals(expected, bmiScores);
    }
}