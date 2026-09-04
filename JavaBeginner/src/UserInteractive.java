import java.util.Scanner;

public class UserInteractive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyBoard = new Scanner(System.in);
		
		String name;
		System.out.println("Please enter your name:");
		name = keyBoard.nextLine();
		System.out.println("Welcome to DJA Bank, " + name + ".");
		
		int age;
		System.out.println("Please enter your age:");
		age = keyBoard.nextInt();
		
		System.out.println(name + ", you are " + age + " years old.");
		
	}

}
