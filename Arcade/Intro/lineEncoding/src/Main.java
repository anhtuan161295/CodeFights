import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.lineEncoding("abbcabb"));
	}

	String lineEncoding(String s) {
		String result = "";

		List<String> chars = s.chars().mapToObj(i -> (char) i).map(j -> String.valueOf(j)).collect(Collectors.toList());

		String finalString = "";
		List<Map<String, Integer>> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		String currentChar;

		for (int i = 0; i < chars.size(); i++) {
			currentChar = chars.get(i);

			if (map.containsKey(currentChar)) {
				int val = map.get(currentChar);
				map.put(currentChar, val + 1);
			} else {

				if (map.isEmpty()) {
					map.put(currentChar, 1);
				} else {
					list.add(map);
					map = new HashMap<>();
					map.put(currentChar, 1);
				}
			}
		}

		// Add last map
		list.add(map);


		for (int i = 0; i < list.size(); i++) {
			Map<String, Integer> m = list.get(i);
			List<String> keys = new ArrayList<>(m.keySet());
			List<Integer> values = new ArrayList<>(m.values());
			String ch = keys.get(0);
			int val = values.get(0);

			if (val > 1) {
				finalString += val + ch;
			} else {
				finalString += ch;
			}
		}

//		System.out.println(list);

		result = finalString;

		return result;
	}

}
