package demopack;

import java.util.ArrayList;

public class SecondCollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = { 4, 5, 5, 5, 4, 6, 6, 9, 4 };

		// how many times is each number repeated and find unique number

		// 4 - 3 times, 5 - 3 times, 6 - 2 times, 9 - 1 time

		// start with an empty arraylist

		ArrayList<Integer> aa = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (!aa.contains(a[i])) {
				int k = 0;

				aa.add(a[i]);
				k++;
				
				for (int j = i + 1; j < a.length; j++) {
					if (a[j] == a[i]) {
						k++;
					}
				}

				System.out.println("The value of " + a[i] + " was found " + k + " times.");
				System.out.println(aa);
			}

		}

	}

}
