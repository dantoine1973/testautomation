import java.util.Scanner;

public class CompareTwoNumbers {
    public static void main(String[] args) {

        float firstNumber, secondNumber;

        Scanner keyBoardInput = new Scanner(System.in);

        System.out.println("Enter a number.");

        firstNumber = keyBoardInput.nextFloat();

        System.out.println("Enter another number.");

        secondNumber = keyBoardInput.nextFloat();

        if (firstNumber == secondNumber)
            System.out.println("The numbers are equal.");
        else if (firstNumber > secondNumber)
            System.out.println("The first number is greater.");
        else
            System.out.println("The second number is greater.");

        keyBoardInput.close();
    }
}
