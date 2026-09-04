package coreJava;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer,Integer> myhm1 = new HashMap<Integer,Integer>();
		HashMap<Integer,String> myhm2 = new HashMap<Integer,String>();
		
		Hashtable<String,String> myht1 = new Hashtable<String,String>();
		
		myhm1.put(0, 0);
		myhm1.put(1, 1);
		myhm1.put(2,  2);
		
		myhm2.put(0,  "0");
		myhm2.put(1,  "1");
		
		myht1.put("a",  "b");
		
		
		System.out.println(myhm1);

		
		System.out.println(myhm2);
		

		System.out.println(myht1);
		
		System.out.println(myhm1.get(0));
		System.out.println(myhm2.get(1));
		
		Set myset1 = myhm1.entrySet();
		
		Iterator it = myset1.iterator();
		
		while (it.hasNext()) {
		
			Map.Entry mp = (Map.Entry)it.next(); // 

			System.out.println(mp);
			
			System.out.println(mp.getKey());
			System.out.println(mp.getValue());
			
			
			
			
		}
			

		
	}

}
