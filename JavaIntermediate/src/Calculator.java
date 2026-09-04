public class Calculator {




    public void add(int number1, int number2) {
        int sum = number1 + number2;
        System.out.println("Sum of the two numbers is " + sum);
    }

    public void add(int number1, float number2) {
        float sum = number1 + number2;
        System.out.println("Sum of the two numbers is " + sum);
    }

    public void add(float number1, float number2) {
        float sum = number1 + number2;
        System.out.println("Sum of the two numbers is " + sum);
    }

    public void add(float number1, int number2) {
        float sum = number1 + number2;
        System.out.println("Sum of the two numbers is " + sum);
    }

    public static void main(String[] args) {
        
        Calculator myCalc = new Calculator();

        myCalc.add(1, 2);
        myCalc.add(1.0f, 2);
        myCalc.add(1, 2.0f);
        myCalc.add(1.0f, 2.0f);



    }
}
