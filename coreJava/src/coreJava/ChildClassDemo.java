package coreJava;

public class ChildClassDemo extends ParentClassDemo {

	public void Engine() {
		System.out.println("New Engine is implemented");
	}
	
	public void Color() {
		System.out.println("Car color is " + color);
	}

	// function overriding between child and parent class
	
	public void Audio() {
		System.out.println("New audio implemented");
	}
	
	// function overloading (via parameters)
	
	public void getData(String a) {
		System.out.println(a);
	}
	
	public void getData(int a) {
		System.out.println(a);
	}

	
	public void getData(int a, int b) {
		System.out.println(a + b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChildClassDemo cc = new ChildClassDemo();
		cc.Color();
		cc.Brakes();
		cc.Audio();
		
		cc.getData(4);
		
		cc.getData("Hi");
		
		cc.getData(5,6);
		
	}

}
