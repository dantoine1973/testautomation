package coreJava;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// HashSet ,TreeSet, LinkedHashSet implements Set interface
		// sets do not accept duplicate values
		// no guarantee that elements are stored in sequential order

		HashSet<String> hs1 = new HashSet<String>();
		LinkedHashSet<Integer> lhs1 = new LinkedHashSet<Integer>();
		TreeSet<Integer> ts1 = new TreeSet<Integer>();

		hs1.add("United");

		hs1.add("of");
		hs1.add("America");

		hs1.add("States");

		System.out.println(hs1);

		System.out.println(hs1.size());

		lhs1.add(3);
		System.out.println(lhs1);

		ts1.add(13);
		System.out.println(ts1);

		Iterator<String> i = hs1.iterator();

		while (i.hasNext()) {
			System.out.print(i.next());
		}

	}

}
