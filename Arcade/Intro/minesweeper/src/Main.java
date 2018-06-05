import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		boolean[][] a = new boolean[][]{
				{true, false, false},
				{false, true, false},
				{false, false, false}
		};
		boolean[][] b = new boolean[][]{
				{true, false, false, true},
				{false, false, true, false},
				{true, true, false, true}
		};
		int[][] rs = main.minesweeper(b);

		for (int[] i : rs) {
			System.out.println(Arrays.toString(i));
		}
	}

	int[][] minesweeper(boolean[][] matrix) {
		int[][] result = null;

		int rowNum = matrix.length;
		int colNum = matrix[0].length;

		int[][] temp = new int[rowNum][colNum];

		// Create a matrix with bomb value = -1
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				temp[i][j] = 0;
			}
		}

		// Check if current cell is bomb, then increase neighboring cells by 1;
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				boolean isBomb = matrix[i][j];

				if (isBomb) {

					for (int k = i - 1; k <= i + 1; k++) {
						for (int l = j - 1; l <= j + 1; l++) {

							if (k >= 0 && k < rowNum && l >= 0 && l < colNum) {
								int cellVal = temp[k][l];
								boolean isBomb2 = matrix[k][l];

								if (!isBomb2) {
									temp[k][l] = cellVal + 1;
								}
							}
						}
					}
				}
			}
		}

		// Check if current cell is bomb, then count if there are any bombs in neighboring cells, then set value for current cell
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				boolean isBomb = matrix[i][j]; // current bomb cell

				if (isBomb) {
					int count = 0;

					for (int k = i - 1; k <= i + 1 && k < rowNum; k++) {
						for (int l = j - 1; l <= j + 1 && l < colNum; l++) {

							// skip if the cell is current bomb cell
							if (k < 0 || l < 0 || (k == i && l == j)) {
								continue;
							}

							boolean isBomb2 = matrix[k][l]; // check neighboring cell is bomb
							if (isBomb2) { //
								count++; // count neighboring bombs
							}

						}
					}

					temp[i][j] += count; // add value for bomb cell
				}
			}
		}

		result = temp;

		return result;
	}
}
