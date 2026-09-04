class Cat {

    String fur = "Hard Black";

    public void Jump() {
        System.out.println("Cats jump!");
    }

    public void eatMice() {
        System.out.println("Cats love to eat mice!");
    }

    public void drinkMilk() {
        System.out.println("Cats drink milk while you are away!");
    }

    public void Meow() {
        System.out.println("Cats like to meow.");
    }

    public void Color() {
        System.out.println("The cat's fur is this color: " + this.fur);
    }
}

class Kitten extends Cat {
    String fur = "Soft Grey";

    public void Meow() {
        System.out.println("Kittens like to meow even more.");
    }

    public void Jump() {
        System.out.println("Kitten jump too but not as high.");
    }

    public void Jump(int i) {
        super.Jump();
    }

}

public class CatTest {

    public static void main(String[] args) {

        Cat myCat = new Cat();
        Kitten myKitten = new Kitten();

        myCat.Jump();
        myCat.drinkMilk();
        myCat.eatMice();
        myCat.Color();

        myKitten.Jump();
        myKitten.Jump(1);
        myKitten.Color();
    }
}
