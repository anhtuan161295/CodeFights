import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		int[] a = new int[]{2, 4, 1, 0};
		System.out.println(main.arrayMaximalAdjacentDifference(a));
	}

	int arrayMaximalAdjacentDifference(int[] inputArray) {
		int result = 0;

		List<Integer> defaultList = Arrays.stream(inputArray).boxed().collect(Collectors.toList());
		int difference = 0;

		for (int i = 0, j = i + 1; i < defaultList.size() && j < defaultList.size(); i++, j++) {
			int current = defaultList.get(i);
			int next = defaultList.get(j);
			int absRange = Math.abs(next - current);

			if (absRange > difference) {
				difference = absRange;
			}
		}

		result = difference;
		return result;
	}
}
