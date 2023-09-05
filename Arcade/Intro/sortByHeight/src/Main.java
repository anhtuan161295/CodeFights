import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		int[] rs = main.sortByHeight(new int[]{-1, 150, 190, 170, -1, -1, 160, 180});
		System.out.println(Arrays.toString(rs));
	}

	int[] sortByHeight(int[] a) {

		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> indexes = new ArrayList<>();
		List<Integer> values = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			int val = a[i];

			result.add(val); // convert array to list

			if (val != -1) {
				map.put(i, val);
				indexes.add(i);
				values.add(val);
			}
		}

		Collections.sort(values);
//		System.out.println(values);
//		System.out.println(map.toString());

		for (int i = 0; i < indexes.size(); i++) {
			int index = indexes.get(i);
			int value = values.get(i);
			result.remove(index);
			result.add(index, value);
		}

//		System.out.println(result);

		int[] rs = result.stream().mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(rs));

		return rs;
	}
}
