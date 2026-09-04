package demopack;

public class SortArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 4;
		int b = 5;
		int temp;

		System.out.println("a = " + a);
		System.out.println("b = " + b);

		// Swap using temp variable

		/*
		 * temp = a; a = b; b = temp;
		 */

		// Swap without temp variable

		a = a + b; // a = 4 + 5 = 9
		b = a - b; // b = 9 - 5 = 4
		a = a - b; // a = 9 - 4 = 5

		System.out.println("a = " + a);
		System.out.println("b = " + b);

		int c[] = { 2, 6, 1, 4, 9 };

		for (int k=0; k < c.length ; k++) {
			System.out.println(c[k]);			
		}
		

		
		/*
		 * bubble sort 1,2,6,4,9
		 * 
		 * 
		 * 
		 */

		for (int i = 0; i < c.length; i++) {
			for (int j = i+1; j < c.length; j++) {
				if (c[i] > c[j]) {
					c[i] = c[i] + c[j];
					c[j] = c[i] - c[j];
					c[i] = c[i] - c[j];
				}		
			}
		}

		for (int k=0; k < c.length ; k++) {
			System.out.println(c[k]);			
		}
	}

}
