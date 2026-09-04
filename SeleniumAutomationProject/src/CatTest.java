class Cat {
	int eyes = 2;
	int tail = 1;

	public void jump() {
		System.out.println("Cats jump!");
	}

	public void eatMice() {
		System.out.println("Cats love to eat mice!");
	}

	public void drinkMilk() {
		System.out.println("Cats drink the milk while you are away!!");
	}
}

public class CatTest {
	public static void main(String[] args) {
		Cat obj = new Cat();
		System.out.println(obj);
		obj.jump();
		obj.eatMice();
		obj.drinkMilk();
	}
}