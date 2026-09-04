package coreJavaTraining;

public class StringClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * In Java, String is one of the prebuilt classes. 1. String literal 2. by
		 * creating String object
		 */

		String a = "javatraining"; // String literal
		String b = "hello";

		String ab = new String("hello");
		String cd = new String("hello"); // String class

		System.out.println(a.charAt(2));
		System.out.println(a.indexOf("e"));

		System.out.println(a.substring(3, 6));
		System.out.println(a.substring(5));
		System.out.println(a.concat(" Rahul teaches"));

		System.out.println(a.trim());
		System.out.println(a.toUpperCase());
		System.out.println(a.toLowerCase());

		// split

		String arr[] = a.split("t");

		System.out.println(arr[0]);
		System.out.println(arr[1]);

		System.out.println(a.replace("t", "s"));
	}

}
