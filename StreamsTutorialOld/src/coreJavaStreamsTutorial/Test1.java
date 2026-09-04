package coreJavaStreamsTutorial;

import java.util.ArrayList;

public class Test1 {

	// Count the number of names staring with "a" in list

	public void regular() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Abhijit");
		names.add("Donald");
		names.add("Annie");
		names.add("Craig");
		names.add("Rob");

		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);

			if (actual.startsWith("A")) {
				count++;
			}
		}

		System.out.println(count);

		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
	}

	public void main (String[] args) {
		
	}
}
