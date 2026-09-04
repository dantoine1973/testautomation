public class OperatorExercise {
    public static void main(String[] args) {
        // different types of operators :
        // arithmetic: + , - , *, / , %
        // relational: < <= >= > == !=
        // logical && || ! (and / or / not)

        int number1 = 10;
        int number2 = 2;
        int quotient = number1 / number2;
        int modulus = number1 % number2;

        System.out.println(quotient);
        System.out.println(modulus);

        System.out.println(number1 < number2);
        System.out.println(number1 > number2);
        System.out.println(number1 == number2);

        System.out.println((number1 == 10) && (number2 == 2));
        System.out.println((number1 == 10) || (number2 == 2));
        System.out.println(!(number1 == 10) || (number2 == 3));
    }
}
