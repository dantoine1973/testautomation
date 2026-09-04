import java.util.Scanner;

public class MovieAdmissionBasedOnAge {
    public static void main(String[] args) {
        int ageInput;

        Scanner keyBoardInput = new Scanner(System.in);

        System.out.println("Enter your age.");

        ageInput = keyBoardInput.nextInt();

        if (ageInput < 16)
            System.out.println("You owe 2 dollars.");
        else if (ageInput >= 60)
            System.out.println("You owe 5 dollars.");
        else
            System.out.println("You owe 10 dollars.");

        System.out.println("Welcome to the movie theater.");

        keyBoardInput.close();
    }
}
