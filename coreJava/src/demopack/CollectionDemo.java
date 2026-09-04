package demopack;

import java.util.ArrayList;

public class CollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// this also includes reversedemo lesson, i.e., checking for palindrome

		int a[] = { 4, 5, 5, 5, 4, 6, 6, 9, 4 };

		String r = "Rahul";

		String s = "madam";

		String t = "";

		for (int i = s.length() - 1; i >= 0; i--) {

			System.out.println(s.charAt(i));

			t += s.charAt(i);

		}

		System.out.println(s);
		System.out.println(t);

	}

}
