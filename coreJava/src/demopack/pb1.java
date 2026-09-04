package demopack;

public class pb1 
{

    public static void main(String[] args) 
    {
        // time for some nested loops
        for (int i = 1; i <= 4; i++) // outer loop that will run 4 times
            {
                System.out.println("outer loop value: " + i);

                for (int j = 1; j <= 4; j++) // inner loop that will run 4 times
                {
                    System.out.println("inner loop value: " + j);
                }
                System.out.println("inner loop done");
            }
            System.out.println("outer loop done");

        for (int k = 1; k <= 10; k++)
            {

                System.out.print(k + " ");

                if ((k == 4) || (k == 7) || (k == 9))
                {
                    System.out.println("");
                }
            }

        int p = 1;

        System.out.println("");

        for (int m = 0; m < 4; m++)
        {
            for (int n = 1; n <= 4 - m; n++)
            {
                System.out.print(p + " ");
                p++;
            }
        
            System.out.println("");
        }



System.out.println("all loops done");

    }
}
