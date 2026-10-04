package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
// import org.junit.jupiter.params.provider.CsvSource;
// import org.junit.jupiter.params.provider.ValueSource;

// import com.healthycoderapp.BMICalculator;
// import com.healthycoderapp.Coder;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

public class BMICalculatorTest {

    private String environment = "prod";

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

    @Nested
    class IsDietRecommendedTest {

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

        @ParameterizedTest(name = "weight={0}, height={1}")
        /*
         * @CsvSource({
         * "89.0, 1.72",
         * "95.0, 1.75",
         * "110.0, 1.78"
         * })
         */
        // @ValueSource(doubles = { 89.0, 95.0, 110.0 })
        @CsvFileSource(resources = "/diet-recommended-input-data.csv", numLinesToSkip = 1)
        void shouldReturnTrue_WhenDietIsRecommended(double coderWeight, double coderHeight) {

            // given
            double weight = coderWeight;
            double height = coderHeight;

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

    @Nested
    class FindCoderWithWorstBMITest {

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
        void shouldReturnCoderWithWorstBMIIn1Ms_WhenCoderListHas10000Elements() {

            // given
            assumeTrue(BMICalculatorTest.this.environment.equals("prod"));
            List<Coder> coders = new ArrayList<>();

            for (int i = 0; i < 10000; i++) {
                coders.add(new Coder(1.0 + i, 10.0 + i));
            }

            // when
            // Coder worstBMICoder = BMICalculator.findCoderWithWorstBMI(coders);

            Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);

            // then

            assertTimeout(Duration.ofMillis(500), executable);

            /*
             * assertAll(
             * () -> assertEquals(1.82, worstBMICoder.getHeight(), 0.01),
             * () -> assertEquals(98.0, worstBMICoder.getWeight(), 0.01));
             */

        }

        @Test
        @Disabled
        void shouldReturnNullWorstBMICoder_WhenCoderListIsEmpty() {

            // given
            List<Coder> coders = List.of();

            // when
            Coder worstBMICoder = BMICalculator.findCoderWithWorstBMI(coders);

            // then
            assertNull(worstBMICoder);
        }

    }

    @Nested
    class GetBMIScoresTest {
        @Test
        @DisplayName ("should return correct BMI scores array when coder list is not empty")
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
}