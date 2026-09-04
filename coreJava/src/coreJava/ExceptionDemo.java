package coreJava;

public class ExceptionDemo {

	// exception handling code - 3 lines using try catch

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int b = 7;

		int c = 1;

		try {
			int k = b / c; // Division by zero throws an error automatically so we have to capture it

			int arr[] = new int[5];

			System.out.println(arr[4]);

		} // catch block should immediately follow try block
		catch (ArithmeticException ae) {
			System.out.println("Arithmetic Exception caught: " + ae);
		} 
		catch (ArrayIndexOutOfBoundsException indexe) {
			System.out.println("Arrary Out of Bounds Exception caught: " + indexe);
		} 
		catch (Exception e) {
			System.out.println("Exception caught: " + e);
		} 
		finally { // This is executed regardless of exceptions thrown
			System.out.println("End of try catch blocks - deleting cookies");
		}
	}
}
