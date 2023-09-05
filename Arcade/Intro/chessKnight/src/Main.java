import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.chessKnight("a1"));
	}

	int chessKnight(String cell) {
		int result = 0;

		List<String> bottomLine = Arrays.asList("", "a", "b", "c", "d", "e", "f", "g", "h");
		List<String> rightLine = Arrays.asList("", "1", "2", "3", "4", "5", "6", "7", "8");

		String knightFirstChar = cell.substring(0, 1);
		String knightSecondChar = cell.substring(1);

		int knightBottomIndex = bottomLine.indexOf(knightFirstChar);
		int knightRightIndex = rightLine.indexOf(knightSecondChar);

		Map<Integer, int[]> map = new HashMap<>();

		map.put(1, new int[]{knightBottomIndex + 2, knightRightIndex + 1});
		map.put(2, new int[]{knightBottomIndex + 2, knightRightIndex - 1});
		map.put(3, new int[]{knightBottomIndex - 2, knightRightIndex + 1});
		map.put(4, new int[]{knightBottomIndex - 2, knightRightIndex - 1});

		map.put(5, new int[]{knightBottomIndex + 1, knightRightIndex + 2});
		map.put(6, new int[]{knightBottomIndex - 1, knightRightIndex + 2});
		map.put(7, new int[]{knightBottomIndex + 1, knightRightIndex - 2});
		map.put(8, new int[]{knightBottomIndex - 1, knightRightIndex - 2});

		List<String> moves = new ArrayList<>();

		for (int i = 1; i < 9; i++) {
			int[] arr = map.get(i);
			int bottomIndex = arr[0];
			int rightIndex = arr[1];

			if (bottomIndex > 0 && rightIndex > 0 && bottomIndex < 9 && rightIndex < 9) {
				String firstChar = bottomLine.get(bottomIndex);
				String secondChar = rightLine.get(rightIndex);
				moves.add(firstChar + secondChar);
			}
		}

//		System.out.println(moves);
		result = moves.size();

		return result;
	}

}
