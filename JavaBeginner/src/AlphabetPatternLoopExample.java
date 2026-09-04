import java.util.Scanner;

public class AlphabetPatternLoopExample {
    public static void main(String[] args) {

        int alphabetASCII = 97;
        int i, j;

        for (i = 0; i <= 10; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print((char)(alphabetASCII) + " ");
                // alphabetASCII++;
            }
            System.out.println("");
            alphabetASCII++;
        }

    }
}
