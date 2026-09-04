package coreJava;

public class InterviewMinNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int abc[][] = { { 2, 4, 5 }, { 3, 0, 7 }, { 1, 2, 9 } };

		int minValue = abc[0][0];

		int maxValue = abc[0][0];

		int minRow = -1;

		int minColumn = -1;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (abc[i][j] < minValue) {
					minValue = abc[i][j];
					minRow = i;
					minColumn = j;
				}

				if (abc[i][j] > maxValue) {
					maxValue = abc[i][j];
				}
			}
		}

		System.out.println("Minimum value = " + minValue);
		System.out.println("Maximum value = " + maxValue);

		int maxColumnValue = abc[0][minColumn];

		int k = 0;
		while (k < 3) {
			if (abc[k][minColumn] > maxColumnValue) {
				maxColumnValue = abc[k][minColumn];
			}
			k++;
		}
		System.out.println("Maximum column value = " + maxColumnValue);
	}
}