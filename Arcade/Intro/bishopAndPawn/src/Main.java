import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.bishopAndPawn("a1", "c3"));
	}

	boolean bishopAndPawn(String bishop, String pawn) {
		boolean result = false;

		List<String> bottomLine = Arrays.asList("", "a", "b", "c", "d", "e", "f", "g", "h");
		List<String> rightLine = Arrays.asList("", "1", "2", "3", "4", "5", "6", "7", "8");

		String bishopFirstChar = bishop.substring(0, 1);
		String bishopSecondChar = bishop.substring(1);

		List<Integer> bishopCoordinate = new ArrayList<>();
		bishopCoordinate.add(bottomLine.indexOf(bishopFirstChar));
		bishopCoordinate.add(rightLine.indexOf(bishopSecondChar));

//		System.out.println(bishopCoordinate);

		int bishopBottom = bottomLine.indexOf(bishopFirstChar);
		int bishopRight = rightLine.indexOf(bishopSecondChar);

		Set<String> moves = new HashSet<>();

		for (int i = bishopBottom, j = bishopRight; i < 9 && j < 9; i++, j++) {
			if (i > 0 && j > 0) {
				String character = bottomLine.get(i);
				String number = rightLine.get(j);
				moves.add(character + number);
			}
		}

		for (int i = bishopBottom, j = bishopRight; i > 0 && j > 0; i--, j--) {
			if (i < 9 && j < 9) {
				String character = bottomLine.get(i);
				String number = rightLine.get(j);
				moves.add(character + number);
			}
		}

		for (int i = bishopBottom, j = bishopRight; i < 9 && j > 0; i++, j--) {
			if (i > 0 && j < 9) {
				String character = bottomLine.get(i);
				String number = rightLine.get(j);
				moves.add(character + number);
			}
		}

		for (int i = bishopBottom, j = bishopRight; i > 0 && j < 9; i--, j++) {
			if (i < 9 && j > 0) {
				String character = bottomLine.get(i);
				String number = rightLine.get(j);
				moves.add(character + number);
			}
		}

		if (moves.contains(pawn)) {
			result = true;
		}

//		System.out.println(moves);

		return result;
	}

}
