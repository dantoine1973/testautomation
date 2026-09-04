package coreJava;

public class ChildEmirates extends ParentAirCraft {

	@Override
	public void bodyColor() {
		// TODO Auto-generated method stub
		System.out.println("red white blue green");
	}
	
	
	public static void main (String[] args) {
		
		ChildEmirates ce = new ChildEmirates();
		
		ce.bodyColor();
		ce.safetyGuidelines();
		ce.engine();
		
	}


}
