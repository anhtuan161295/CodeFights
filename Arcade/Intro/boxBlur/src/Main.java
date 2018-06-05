import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		int[][] a = new int[][]{
				{36, 0, 18, 9},
				{27, 54, 9, 0},
				{81, 63, 72, 45}
		};
		int[][] rs = main.boxBlur(a);
		for (int[] i : rs) {
			System.out.println(Arrays.toString(i));
		}
	}

	int[][] boxBlur(int[][] image) {
		int[][] result = new int[0][0];

		int rowNum = image.length;
		int colNum = image[0].length;
		boolean isRowLargerThan3 = rowNum > 3;
		boolean isColLargerThan3 = colNum > 3;

		int total = 0; // total 3x3 squares

		Map<Integer, List<Integer>> map = new HashMap<>();

		if (rowNum >= 3 && colNum >= 3) {

			for (int i = 0; i < rowNum; i++) {
				for (int j = 0; j < colNum; j++) {

					int rightBorderIndex = i + 2; // right and bottom borders of the square
					int bottomBorderIndex = j + 2;

					if (rightBorderIndex < rowNum && bottomBorderIndex < colNum) {
						int output = 0;
						for (int k = i; k <= rightBorderIndex; k++) {
							for (int l = j; l <= bottomBorderIndex; l++) {
								int cellValue = image[k][l];
								output += cellValue;
							}
						}
						output /= 9;

						if (map.containsKey(i)) {
							List<Integer> values = map.get(i);
							values.add(output);
						} else {
							List<Integer> values = new ArrayList<>();
							values.add(output);
							map.put(i, values);
						}

						total++;
					}
				}
			}
		}

		if (!map.isEmpty()) {
			List<Integer> values = map.get(0);
			result = new int[map.size()][values.size()];
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			int rowIndex = entry.getKey();
			List<Integer> values = entry.getValue();

			for (int i = 0; i < values.size(); i++) {
				result[rowIndex][i] = values.get(i);
			}

		}

//		for (int[] i : result) {
//			System.out.println(Arrays.toString(i));
//		}

//		System.out.println(map);
//		System.out.println(total);

		return result;
	}

}
