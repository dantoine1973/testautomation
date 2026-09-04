package coreJava;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Strings are immutable, but...
		
		String a = "hello"; // String literal
		String b = "hello";
		
		String c = a.concat("world");
		System.out.println(c);
		
		String s = new String("hello"); // String class object
		String s1 = new String("hello");
		
		
		System.out.println(a.equals(b));
		System.out.println(a == b);

		System.out.println(a.equals(s));

		System.out.println(a.equalsIgnoreCase(s));
		
		System.out.println(a == s);
		System.out.println(s == s1);		
		
		// StringBuffer and StringBuilder are not...
		
		StringBuffer sb = new StringBuffer("hello");
		sb.append("world");
		System.out.println(sb);
		
		sb.insert(2, "She");
		System.out.println(sb);
		sb.replace(5, 7, "aa");
		System.out.println(sb);
		sb.deleteCharAt(12);
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
	}

}
