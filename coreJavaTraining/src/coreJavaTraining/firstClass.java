package coreJavaTraining;

public class firstClass 
{
	// Fields
	
	public int number;
	public String greeting;

	// Constructor
	
	public firstClass(int number, String greeting)
	{
		this.number = number;
		this.greeting = greeting;
	}

	// Methods
	
	public void getData() 
	{
		System.out.println("I am in method getData()");
	}
	
	public int get_intData() 
	{
		System.out.println("I am in method get_intData()");
		return this.number;
	}
		
	public String get_StringData() 
	{
		System.out.println("I am in method get_strData()");
		return this.greeting;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		// new class instance
	
		firstClass my_firstClass = new firstClass(5, "Hi there!");
		
		// println vs print
		
		// System.out.print("number = ");
		System.out.println("number = " + my_firstClass.get_intData());
		System.out.println(my_firstClass.get_StringData());
		
		if (my_firstClass.number == 4)
			System.out.println("Hello World!");
		else
			System.out.println(my_firstClass.greeting);
		
		for (int i = 0; i < 2; i++)
		{
			System.out.println("Goodbye!");
		}
	}
}