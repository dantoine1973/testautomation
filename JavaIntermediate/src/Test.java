class Shape {
    float length;
    float width;

    public Shape(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float area() {
        return (this.length * this.width);
    }

    public float perimeter() {
        return (2 * length + 2 * width);
    }

    public void printDimensions() {
        System.out.println("The shape has a length of " + this.length);
        System.out.println("The shape has a width of " + this.width);
    }
}

class Square extends Shape {

    public Square(float length) {
        super(length, length);
    }
}

class Circle extends Shape {
    float radius;

    public Circle (float radius) {
        super(radius, radius);
        this.radius = radius;
    }

    public void printDimensions() {
        System.out.println("The circle has a radius of " + this.radius);
    }

    public float area() {
        return (float) (3.14f * this.radius * this.radius);
    }

    public float perimeter() {
        return (float) (2 * 3.14 * this.radius);
    }

}

public class Test {
    public static void main(String[] args) {

        Shape myRect = new Shape(3.9f,9.4f);
        Square mySquare = new Square(7.2f);
        Circle myCircle = new Circle(4.5f);

        System.out.println(myRect.area());
        System.out.println(myRect.perimeter());
        System.out.println(mySquare.area());
        System.out.println(mySquare.perimeter());
        System.out.println(myCircle.area());
        System.out.println(myCircle.perimeter());
    }
}
