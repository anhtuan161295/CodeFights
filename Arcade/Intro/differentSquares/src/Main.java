import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		int[][] a = new int[][]{
				{9, 9, 9, 9, 9},
				{9, 9, 9, 9, 9},
				{9, 9, 9, 9, 9},
				{9, 9, 9, 9, 9},
				{9, 9, 9, 9, 9},
				{9, 9, 9, 9, 9}
		};

		System.out.println(main.differentSquares(a));
	}

	int differentSquares(int[][] matrix) {
		int result = 0;

		int rowNum = matrix.length;
		int colNum = matrix[0].length;

		List<int[][]> list = new ArrayList<>();

		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {

				int rightIndex = j + 1;
				int bottomIndex = i + 1;

				if (bottomIndex < rowNum && rightIndex < colNum) {
					int[][] a = new int[][]{
							{
									matrix[i][j],
									matrix[i][rightIndex]
							},
							{
									matrix[bottomIndex][j],
									matrix[bottomIndex][rightIndex]
							}};


					list.add(a);

				}

			}
		}

		for (int i = 0; i < list.size(); i++) {
			int[][] a = list.get(i);

			for (int j = list.size() - 1; j > -1; j--) {

				if (i != j) {
					int[][] b = list.get(j);

					if (Arrays.deepEquals(a, b)) {
						list.remove(j);
					}
				}
			}

		}

//		for (int i = 0; i < list.size(); i++) {
//			int[][] arr = list.get(i);
//
//			for (int i1 = 0; i1 < arr.length; i1++) {
//				int[] a = arr[i1];
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println("");
//		}

		result = list.size();

		return result;
	}

}
