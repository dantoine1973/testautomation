package coreJava;

public class ChildDemo extends ParentDemo {

	String name = "Antoine";
	
	public ChildDemo() {
	//	super();
		System.out.println("Child class constructor");
	}
	
	
	public void getString() {
		System.out.println(this.name);
		System.out.println(super.name);
	}
	
	public void getData() {
//		super.getData();
		System.out.println("I am the child demo class.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChildDemo cd1 = new ChildDemo();
		cd1.getString();
		cd1.getData();
		
	}
	
}
