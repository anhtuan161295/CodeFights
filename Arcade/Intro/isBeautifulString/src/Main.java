import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.isBeautifulString("zaa"));
	}

	boolean isBeautifulString(String inputString) {
		boolean result = true;

		if (!inputString.contains("a")) {
			return false;
		}

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		List<String> alphabetList = alphabet.chars().mapToObj(i -> (char) i).map(j -> String.valueOf(j)).collect(Collectors.toList());

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < alphabetList.size(); i++) {
			map.put(alphabetList.get(i), 0);
		}

		List<String> defaultList = inputString.chars().mapToObj(i -> (char) i).map(j -> String.valueOf(j)).collect(Collectors.toList());

		defaultList.sort((o1, o2) -> o1.compareTo(o2));

		for (String s : defaultList) {
			if (map.containsKey(s)) {
				int val = map.get(s);
				map.put(s, val + 1);
			} else {
				map.put(s, 1);
			}
		}

		System.out.println(map);

		List<String> keys = new ArrayList<>(map.keySet());

		int beforeCharCount = map.get("a");

		for (int i = 1; i < keys.size(); i++) {
			String character = keys.get(i);
			int currentCharCount = map.get(character);

			if (beforeCharCount > 0 && currentCharCount > 0) {
				if (currentCharCount > beforeCharCount) {
					result = false;
					break;
				}
			} else if (beforeCharCount == 0 && currentCharCount > 0) {
				result = false;
				break;
			}

			beforeCharCount = currentCharCount;
		}

		return result;
	}

}
