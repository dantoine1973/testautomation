import java.util.Scanner;

public class ExceptionHandlingExercise {
    public static void main(String[] args) {
        
        Scanner keyBoardInput = new Scanner(System.in);
        int input;

        System.out.println("Enter an integer.");

        try {
            input = keyBoardInput.nextInt();
        } catch (Exception exceptionError) {
            System.out.println("The value entered is not an integer : " + exceptionError);
        } finally {
            System.out.println("End exception handling loop");
        }

        keyBoardInput.close();

    }
}
