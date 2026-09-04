import java.util.Scanner;

public class CelsiusFahrenheitConvertor {
    public static void main(String[] args) {
        int celsiusStart, celsiusEnd;
        float fTemp;

        Scanner keyBoardInput = new Scanner(System.in);

        System.out.println("Enter the starting Celsius temperature.");

        celsiusStart = keyBoardInput.nextInt();

        System.out.println("Enter tne ending Celsius temperature.");

        celsiusEnd = keyBoardInput.nextInt();

        System.out.println("CELSIUS\tFAHRENHEIT");

        for (int i = celsiusStart; i <= celsiusEnd; i++) {
            fTemp = (float) (i * 1.8 + 32);
            System.out.println(i + "\t" + fTemp);
        }
    }
}
