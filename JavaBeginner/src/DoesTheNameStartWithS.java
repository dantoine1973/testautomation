import java.util.Scanner;

public class DoesTheNameStartWithS {
    public static void main(String[] args) {

        Scanner keyBoard = new Scanner(System.in);

        String name;

        System.out.println("Enter a name");

        name = keyBoard.nextLine().toLowerCase();

        // String lowercaseName = name.toLowerCase();

        if (name.startsWith("s"))
            System.out.println("The name starts with s");
        else
            System.out.println("The name does not start with s");

    }
}
