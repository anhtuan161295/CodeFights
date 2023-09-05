import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		int[][] a = new int[][]{
				{1, 2, 3, 4, 5, 6, 7, 8, 9},
				{4, 6, 5, 8, 7, 9, 3, 2, 1},
				{7, 9, 8, 2, 1, 3, 6, 5, 4},
				{1, 2, 3, 4, 5, 6, 7, 8, 9},
				{4, 6, 5, 8, 7, 9, 3, 2, 1},
				{7, 9, 8, 2, 1, 3, 6, 5, 4},
				{1, 2, 3, 4, 5, 6, 7, 8, 9},
				{4, 6, 5, 8, 7, 9, 3, 2, 1},
				{7, 9, 8, 2, 1, 3, 6, 5, 4}
		};
		System.out.println(main.sudoku(a));
	}

	boolean sudoku(int[][] grid) {
		boolean result = true;

		// Check row
		for (int i = 0; i < 9; i++) {
			int[] row = grid[i];

			if (!isValid(row)) {
				return false;
			}
		}

		// Check column
		for (int i = 0; i < 9; i++) {
			int[] col = new int[9];
			for (int j = 0; j < 9; j++) {
				col[j] = grid[j][i];
			}

//			System.out.println(Arrays.toString(col));

			if (!isValid(col)) {
				return false;
			}
		}

		// Check sub grid
		List<int[]> list = new ArrayList<>();

		for (int i = 0, j = i + 2; i < 9 && j < 9; i += 3, j += 3) {

			for (int k = 0, l = k + 2; k < 9 && l < 9; k += 3, l += 3) {

				List<Integer> subGrid = new ArrayList<>();
				for (int m = i; m <= j; m++) {
					for (int n = k; n <= l; n++) {
//						System.out.println(grid[m][n]);
						subGrid.add(grid[m][n]);
					}
				}

				int[] arr = subGrid.stream().mapToInt(q -> q).toArray();
				list.add(arr);
			}
		}

		for (int i = 0; i < list.size(); i++) {
//			System.out.println(Arrays.toString(list.get(i)));
			if (!isValid(list.get(i))) {
				return false;
			}
		}


		return result;
	}

	private boolean isValid(int[] a) {
		int[] validRow = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
		int[] row = list.stream().mapToInt(i -> i).toArray();
		Arrays.sort(row);
//		System.out.println(Arrays.toString(row));
		return Arrays.equals(validRow, row);
	}
}
