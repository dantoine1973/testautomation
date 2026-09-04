package demopack;

public class loop2demo 
{


    public static void main(String[] args) 
    {
        int w = 1;

        for (int u = 0; u < 4; u++)
        {
            for (int v = 0; v <= u; v++)
            {
                System.out.print(w + " ");
                w++;
            }
            System.out.println("");
        }
    }
}
