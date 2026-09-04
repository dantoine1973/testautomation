import java.util.Scanner;

public class EvenOrOddNumber {
    public static void main(String[] args) {

        int numberInput;

        Scanner keyBoard = new Scanner(System.in);

        System.out.println("Enter an integer.");

        numberInput = keyBoard.nextInt();

        if (numberInput % 2 == 0)
            System.out.println("The number entered is even.");
        else
            System.out.println("The number entered is odd.");

        keyBoard.close();
    }
}
