package coreJava;

public class StaticVar {

	// Instance variables
	
	String name;
	String address;
	
	// class variables
	
	static String city;
	static int i;
	
	static {
		city = "Woodmere";
		i = 0;
	}
	
	public StaticVar(String name, String address) {
		this.name = name;
		this.address = address;
		i++;
//		this.city = "Woodmere";
//		System.out.println(i);
	}
	
	public void getAddress() {
		System.out.println(address + " " + city);
	}
	
	public static void getCity() {
		System.out.println(city);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StaticVar svObj = new StaticVar("Bob", "Central Avenue");
		StaticVar svObj1 = new StaticVar("Rob", "Northwood Lane");
		StaticVar svObj2 = new StaticVar("Dave", "Broadway Lane");
		svObj.getAddress();
		svObj1.getAddress();
		svObj2.getAddress();

		System.out.println(StaticVar.i);
		StaticVar.getCity();
		
	//	System.out.println(svObj.name);
	}

}
