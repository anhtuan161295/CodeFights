import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.palindromeRearranging("abbcabb"));
	}

	boolean palindromeRearranging(String inputString) {
		boolean result = false;

		if (inputString.length() == 1) {
			return true;
		}

		// count the occurence of every character in string
		Map<String, Integer> map = inputString.chars().
				mapToObj(i -> (char) i).
				map(i -> String.valueOf(i)).
				collect(Collectors.groupingBy(s -> s, Collectors.summingInt(s -> 1)));

		System.out.println(map);

		boolean isSameOccurence = true; // check if every character has same number of occurences.
		int numberOfExceptOneLetter = 0; // count if any character has different number of occurences.

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			int num = entry.getValue();

			if (num % 2 != 0) {
				isSameOccurence = false;
				numberOfExceptOneLetter++;
			}
		}

		// Check if input length is even or odd case
		if (inputString.length() % 2 == 0 && isSameOccurence) {
			result = true;

		} else if (inputString.length() % 2 != 0 && !isSameOccurence && numberOfExceptOneLetter == 1) {
			result = true;
		}

		return result;
	}
}
