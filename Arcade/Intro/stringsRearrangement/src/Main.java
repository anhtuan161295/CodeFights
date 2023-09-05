import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		String[] a = new String[]{
				"abc",
				"bef",
				"bcc",
				"bec",
				"bbc",
				"bdc"
		};
		System.out.println(main.stringsRearrangement(a));
	}

	boolean stringsRearrangement(String[] inputArray) {
		boolean result = true;

		if (inputArray.length == 1) {
			return false;
		}

		List<String> defaultList = Arrays.asList(inputArray);

		// Try unsorted and sorted list
		result = checkRearrangement(defaultList);

		if (!result) {
			List<String> sortedList = new ArrayList<>(defaultList);
			Collections.sort(sortedList);
			result = checkRearrangement(sortedList);
		}

		// Try swapping elements
		if (!result) {
			for (int i = 0; i < defaultList.size(); i++) {
				if (result) {
					break;
				}

				for (int j = i + 1; j < defaultList.size(); j++) {
					Collections.swap(defaultList, i, j);
					System.out.println(defaultList);
					result = checkRearrangement(defaultList);
					System.out.println("" + result);
					if (result) {
						break;
					}
				}
			}
		}

		return result;
	}

	private boolean checkRearrangement(List<String> defaultList) {
		boolean result = true;

		List<List<String>> list = new ArrayList<>();

		for (int i = 0; i < defaultList.size(); i++) {
			String s = defaultList.get(i);
			List<String> characters = s.chars().mapToObj(b -> (char) b).map(a -> String.valueOf(a)).collect(Collectors.toList());
			list.add(characters);
		}

		for (int i = 0, j = i + 1; i < list.size() && j < list.size(); i++, j++) {

			List<String> currentString = list.get(i);
			List<String> nextString = list.get(j);

//			System.out.println(currentString);
//			System.out.println(nextString);

			boolean isDifferent = false;

			int differentChar = 0;

			for (int k = 0; k < currentString.size(); k++) {
				String c1 = currentString.get(k);
				String c2 = nextString.get(k);

				if (!c2.equals(c1)) {
					differentChar++;
				}
			}

			if (differentChar == 1) {
				isDifferent = true;
			}

			if (!isDifferent) {
				result = false;
				break;
			}

//			System.out.println("" + isDifferent);
		}

		return result;
	}
}
