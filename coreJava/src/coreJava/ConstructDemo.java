package coreJava;

public class ConstructDemo {

	int a;
	
	public ConstructDemo() {
		System.out.println("Constructor initialization sets nothing");
	}
	
	public ConstructDemo(int b) {
		
		this.a = b;
		System.out.println("Constructor initialization sets a to " + this.a);
		
	}
	
	public ConstructDemo(String b) {
		
		// this.a = b;
		System.out.println("Constructor initialization prints " + b);
		
	}
	
	public void getData() {
		System.out.println("getData class function printing " + a);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConstructDemo cd = new ConstructDemo(7);
		ConstructDemo ce = new ConstructDemo();
		ConstructDemo cf = new ConstructDemo("Hi there!");
		cd.getData();
	}

}
