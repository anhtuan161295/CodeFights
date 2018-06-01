import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		int[] a = new int[]{16, 19, 21, 25};
		System.out.println(main.avoidObstacles(a));
	}

	int avoidObstacles(int[] inputArray) {
		int result = 0;

		List<Integer> defaultList = Arrays.stream(inputArray).boxed().collect(Collectors.toList());

		int min = Collections.min(defaultList);
		int max = Collections.max(defaultList);

		// numbers not in input array
		List<Integer> candidates = new ArrayList<>();

		// input always larger or equal 1
		for (int i = 1; i < max; i++) {
			if (!defaultList.contains(i)) {
				candidates.add(i);
			}
		}

		// Filter candidates by using input values to divide candidates.
		List<Integer> valuesToRemove = new ArrayList<>();

		for (int i = 0; i < defaultList.size(); i++) {
			int number = defaultList.get(i);

			for (int n : candidates) {
				if (number % n == 0 && !valuesToRemove.contains(n)) {
					valuesToRemove.add(n);
					break;
				}
			}
		}

//		System.out.println(valuesToRemove);
		candidates.removeAll(valuesToRemove);

		// Filter again by multiply the candidates and check if the step exists in input array
		valuesToRemove = new ArrayList<>();
		for (int i = 1; i < max; i++) {
			for (int n : candidates) {
				int step = i * n;

				if (defaultList.contains(step) && step < max && !valuesToRemove.contains(n)) {
					valuesToRemove.add(n);
					break;
				}

			}
		}

		candidates.removeAll(valuesToRemove);

//		System.out.println(candidates);

		if (candidates.isEmpty()) {
			result = max + 1; // no candidates then result is one more step ahead
		} else {
			result = Collections.min(candidates); // return minimum candidate
		}

		return result;
	}
}
