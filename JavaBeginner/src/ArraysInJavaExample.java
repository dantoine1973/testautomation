public class ArraysInJavaExample {
    public static void main(String[] args) {

        int[] age = { 10, 20, 30, 40, 50 };
        String[] name = { "David", "Dana", "Philip", "Lydia" };
        float[] weight = { 14.0f, 70.1f, 80.3f, 45.23f, 104.567f, 210.4f };
        char[] initial = { 'D', 'J', 'A', 'L', 'K' };

        int i;

        for (i = 0; i < age.length; i++)
            System.out.print(age[i] + " ");

        System.out.println("");

        for (i = 0; i < name.length; i++)
            System.out.print(name[i] + " ");

        System.out.println("");

        for (i = 0; i < weight.length; i++)
            System.out.print(weight[i] + " ");

        System.out.println("");

        for (i = 0; i < initial.length; i++)
            System.out.print(initial[i] + " ");

        System.out.println("");

    }
}
