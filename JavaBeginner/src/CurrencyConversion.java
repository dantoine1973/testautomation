import java.util.Scanner;

public class CurrencyConversion {

	public static void main(String[] args) {

		Scanner keyBoard = new Scanner(System.in);
		float indianRupees;
		float britishPounds;
		float rupeesConversionRate = 0.0078f;
		float poundsConversionRate = 128.03f;

		System.out.println("Enter the amount of Indian Rupees you wish to convert to British pounds.");

		indianRupees = keyBoard.nextFloat();

		britishPounds = indianRupees * rupeesConversionRate;

		System.out.println("The converted amount is " + britishPounds);

		System.out.println("Enter the amount of British Pounds you wish to convert to Indian Rupees.");

		britishPounds = keyBoard.nextFloat();

		indianRupees = britishPounds * poundsConversionRate;

		System.out.println("The converted amount is " + indianRupees);

		keyBoard.close();

	}
}
