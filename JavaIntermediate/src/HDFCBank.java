import java.util.Scanner;

class HDFC {
    private int customerId;
    public String customerName;
    float balance = 1000.00f;

    public void deposit(float depositAmount) {
        this.balance += depositAmount;
    }

    public void withdrawal(float withdrawalAmount) {
        this.balance -= withdrawalAmount;
    }

    public void addNominee() {

    }

    public void addPayee() {

    }

    public void printBalance() {
        System.out.println("Your current balance is " + this.balance);
    }
}

class HDFCBranch extends HDFC {

}

public class HDFCBank {

    public static void main(String[] args) {
        HDFC myBank = new HDFC();
        int choice;
        Scanner keyBoard = new Scanner(System.in);

        System.out.println("Welcome to HDFC Bank - we are happy to help you!");

        do {
            System.out.println("Please press 1 for deposit.");
            System.out.println("Please press 2 for withdrawal.");
            System.out.println("Please press 3 for adding a nominee to your account.");
            System.out.println("Please press 4 for adding a payee to your account.");
            System.out.println("Please press 5 to exit.");

            choice = keyBoard.nextInt();
            System.out.println("You have chosen option " + choice);

            switch (choice) {
                case 1:
                    System.out.println("How much would you like to deposit?");
                    float depositAmount = keyBoard.nextFloat();
                    myBank.deposit(depositAmount);
                    myBank.printBalance();
                    break;
                case 2:
                    System.out.println("How much would you like to withdraw?");
                    float withdrawalAmount = keyBoard.nextFloat();
                    myBank.withdrawal(withdrawalAmount);
                    myBank.printBalance();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Have a wonderful day.");
                default:
                    System.out.println("The option entered is not valid.");
                    break;
            }
        } while (choice != 5);
        keyBoard.close();
    }
}
