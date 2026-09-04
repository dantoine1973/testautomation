package demopack;

public class AustralianTraffic implements CentralTraffic, ContinentalTraffic {

	@Override
	public void greenGo() {
		// TODO Auto-generated method stub
		System.out.println("greenGo implementation");
	}

	@Override
	public void redStop() {
		// TODO Auto-generated method stub
		System.out.println("redStop implementation");
	}

	@Override
	public void yellowFlashing() {
		// TODO Auto-generated method stub
		System.out.println("yellowFlashing implementation");
	}
	
	public void walkOnSymbol() {
		System.out.println("walkOnSymbol implementation");
	}
	
	@Override
	public void trainSymbol() {
		// TODO Auto-generated method stub
		System.out.println("trainSymbol implementation");
	}
	
	public static void main(String[] args) {
		
		CentralTraffic a = new AustralianTraffic();
		
		a.greenGo();
		
		a.redStop();
		
		a.yellowFlashing();
		
		// System.out.println(a.b);
		
		ContinentalTraffic ct = new AustralianTraffic();
		
		ct.trainSymbol();
		
		AustralianTraffic c = new AustralianTraffic();
		
		c.walkOnSymbol();
//		System.out.println(c.b);
	}




}
