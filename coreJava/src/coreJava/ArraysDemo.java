package coreJava;

public class ArraysDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// array definition

		int myvar;
		myvar = 5;

		int myArray[] = new int[myvar]; // declares array and allocates memory for the values
		// int b[] = new int[10];

		int newArray[] = { 0, 1, 1, 2, 3, 5, 8, 13 }; // fibonacci sequence

		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = i * i;
			System.out.println(myArray[i]);
		}

		int j = 2;

		/*
		 * // do // { // newArray[j] = newArray[j-1] + newArray[j-2]; // j++; // } //
		 * while (newArray[j] < 1000);
		 */

		for (int i = 0; i < newArray.length; i++) {
			System.out.println(newArray[i]);
		}

	}

	// public / private / protected / default

	// default - accessible anywhere only in package but not outside of it

	void abcd() {
		System.out.println("hello");
	}

	// public - accessible across all packages

	public void efgh() {
		System.out.println("hello");
	}

	// private - cannot access outside of class

	private void ijkl() {
		System.out.println("hello");
	}

	// protected - only child/sub classes can access

	protected void mnop() {
		System.out.println("hello");
	}

}