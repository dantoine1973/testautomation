import java.util.Scanner;

public class NumberPatternLoopExample {
    public static void main(String[] args) {

        int numRows;
        Scanner keyBoardInput = new Scanner(System.in);

        System.out.println("How many rows of numbers do you want?");

        numRows = keyBoardInput.nextInt();

        int i, j, k;

        k = 1;

        for (i = 1; i <= numRows; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(k + " ");
                k++;
            }
            System.out.println("");
        }

    }
}
