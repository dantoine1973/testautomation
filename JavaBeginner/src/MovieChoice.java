import java.util.Scanner;

public class MovieChoice {
    public static void main(String[] args) {
        Scanner keyBoardInput = new Scanner(System.in);
        String comedyChoice;
        String musicalChoice;

        System.out.println("Would you like to watch comedy?");

        comedyChoice = keyBoardInput.nextLine();

        if ((comedyChoice.equalsIgnoreCase("yes")) || (comedyChoice.equalsIgnoreCase("y")))
            System.out.println("The Princess Bride / Spaceballs / Big Trouble in Little China");
        else {
            System.out.println("Would you like to watch a musical?");
            musicalChoice = keyBoardInput.nextLine(); 
            
            if ((musicalChoice.equalsIgnoreCase("yes")) || (musicalChoice.equalsIgnoreCase("y")))
                System.out.println("Chicago / Les Miserables / Mamma Mia");

            else
                System.out.println("The Odyssey");
            
            
        }

        keyBoardInput.close();
    }
}
