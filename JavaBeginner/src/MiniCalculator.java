public class MiniCalculator {
    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 2;
        int sum = number1 + number2;
        int difference = number1 - number2;
        int product = number1 * number2;
        int quotient = number1 / number2;
        int remainder = number1 % number2;

        System.out.println("Sum = " + sum);
        System.out.println("Difference = " + difference);
        System.out.println("Product = " + product);
        System.out.println("Quotient = " + quotient);
        System.out.println("Remainder = " + remainder);

        System.out.println(number1 < number2);
        System.out.println(number1 >= number2);

        System.out.println((number1==10) &&(number2==2));
    }
}
