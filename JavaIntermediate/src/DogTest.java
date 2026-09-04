class Dog {
    int eyes = 2;
    int tail = 1;
    String name;
    String furColor;

    // constructor

    public Dog(String name, String color) {
        this.name = name;
        this.furColor = color;
    }

    public void Bark() {
        System.out.println("Dogs like to bark!");
    }

    public void wagTail() {
        System.out.println("The dog is wagging its tail.");
    }

    public void Jump() {
        System.out.println("The dog likes to jump up.");
    }

    public void Sleep() {
        System.out.println("Dogs like to take naps.");
    }

    public void Name() {
        System.out.println("The dog's name is " + this.name);
    }

    public void Fur() {
        System.out.println("The dog has a fur color of " + this.furColor);
    }
}

public class DogTest {
    public static void main(String[] args) {

        Dog myDog = new Dog("Spot", "brown");

        myDog.Name();
        myDog.Fur();
        myDog.Sleep();
        myDog.Jump();
        myDog.wagTail();

    }
}
