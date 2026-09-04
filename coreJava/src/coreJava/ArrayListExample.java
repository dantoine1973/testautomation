package coreJava;

import java.util.ArrayList;

public class ArrayListExample {

	// Array has fixed size while ArrayList can grow dynamically
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> a = new ArrayList<Integer>();
		
		ArrayList<String> b = new ArrayList<String>();
		
		a.add(3);
		a.add(7);
		a.add(15);
		a.add(25);
		a.add(30);
		a.add(35);
		
		a.remove(1);
		
		b.add("Mr.");
		b.add("David");
		b.add("Joseph");
		b.add(2, "Antoine");
		b.add(3, "Sir");
		
		b.remove(0);
		
		System.out.println(a);
		System.out.println(a.get(2));
		System.out.println(b);
		
		System.out.println(b.contains("david"));
		
		System.out.println(a.indexOf(25));
		System.out.println(b.indexOf("Joseph"));

		System.out.println("The arraylist length of a is: " + a.size());
		System.out.println("The arraylist length of b is: " + b.size());
	}

}
