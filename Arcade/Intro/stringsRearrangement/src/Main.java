import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		String[] a = new String[]{
				"aba",
				"bbb",
				"bab"
		};
		System.out.println(main.stringsRearrangement(a));
	}

	boolean stringsRearrangement(String[] inputArray) {
		boolean result = false;

		List<List<String>> list = new ArrayList<>();

		for (String s : inputArray) {
			List<String> characters = s.chars().mapToObj(i -> (char) i).map(a -> String.valueOf(a)).collect(Collectors.toList());

			Collections.sort(characters);

			// Remove duplicate
			Set<String> set = new HashSet<>();
			set.addAll(characters);

			characters.clear();
			characters.addAll(set);

			list.add(characters);
		}

		for (int i = 0, j = i + 1; i < list.size() && j < list.size(); i++, j++) {

			List<String> currentString = list.get(i);
			List<String> nextString = list.get(j);

			boolean isDifferent = false;

			if (currentString.size() != nextString.size()) {
				isDifferent = true;
			} else if (currentString.size() == 1 && nextString.size() == 1) {
				String c1 = currentString.get(0);
				String c2 = nextString.get(0);

				if (!c1.equals(c2)) {
					isDifferent = true;
				}
			} else if (currentString.size() < nextString.size() && currentString.size() == 1) {

				String c1 = currentString.get(0);
				isDifferent = nextString.contains(c1);

			} else if (currentString.size() > nextString.size() && nextString.size() == 1) {

				String c1 = nextString.get(0);
				isDifferent = currentString.contains(c1);

			} else {
				for (String s : nextString) {
					if (!currentString.contains(s)) {
						isDifferent = true;
						break;
					}
				}
			}

//			System.out.println(isDifferent);

			if (isDifferent) {
				result = true;
			} else {
				result = false;
				break;
			}
		}

//		System.out.println(list);

		return result;
	}
}
