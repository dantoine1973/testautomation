package coreJava;

public class MultiDimensionalArrayDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// multidimensional array
		
	//	int a[][] = new int[2][3];
		
		int a[][] = {{2,4,7}, {9,5,6}};
		
		/*
		 * a[0][0] = 2; a[0][1] = 4; a[0][2] = 7; a[1][0] = 9; a[1][1] = 5; a[1][2] = 6;
		 */
		
		
		int b[][] = {{1,3,5}, {2,4,6}, {3,6,9}, {4,8,12}};
		
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[0].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}

		
		for (int i = 0; i < b.length; i++)
		{
			for (int j = 0; j < b[0].length; j++)
			{
				System.out.print(b[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
