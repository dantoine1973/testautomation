public class ForLoopExample {
    public static void main(String[] args) {

        int i, j;

        for (i = 35; i <= 80; i++) {
            System.out.println("Hello # " + i);
        }

        i = 80;

        do {
            System.out.println("Goodbye # " + i);
            i--;
        } while (i >= 35);

        i = 0;

        while (i <= 5) {
            j = 0;
            while (j <= 2) {
                System.out.println("Inner nested while loop");
                j++;
            }
            System.out.println("Outer nested while loop");
            i++;
        }

        for (i = 1; i <= 5; i++) {
            for (j = 1; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

        for (i = 4; i >= 0; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

        while (i < 5) {
            System.out.println("Hi # " + i);
            i++;
        }

        i = 10;

        while (i > 0) {
            System.out.println("Bye # " + i);
            i--;
        }

        for (i = 8; i < 20; i++) {
            if (i % 3 == 1)
                System.out.println("\t" + i);
            else
                System.out.print("\t" + i);
        }
    }
}