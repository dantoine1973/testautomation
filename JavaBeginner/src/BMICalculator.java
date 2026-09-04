import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {

        Scanner keyBoard = new Scanner(System.in);
        float weight, height;

        System.out.println("Please enter your weight (in lbs).");

        weight = keyBoard.nextFloat();

        System.out.println("Please enter your height (in inches).");

        height = keyBoard.nextFloat();

        float bmi = (weight / (height * height)) * 703;

        System.out.println("Your BMI is : " + bmi);

        if (bmi < 18.5)
            System.out.println("You are considered underweight.");
        else if (bmi >= 18.5 && bmi < 25)
            System.out.println("You are considered normal/healthy");
        else if (bmi >= 25 && bmi <= 30)
            System.out.println("You are considered overweight");
        else if (bmi >= 30 && bmi < 35)
            System.out.println("You are considered obese class 1");
        else if (bmi >= 35 && bmi < 40)
            System.out.println("You are considered obese class 2");
        else if (bmi >= 40)
            System.out.println("You are considered obese class 2");
    }
}
