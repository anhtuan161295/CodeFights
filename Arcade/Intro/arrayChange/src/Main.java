import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
//		int[] a = new int[]{2, 1, 10, 1};
//		int[] a = new int[]{1, 1, 1};
		int[] a = new int[]{2, 3, 3, 5, 5, 5, 4, 12, 12, 10, 15};
		System.out.println(main.arrayChange(a));
	}

	int arrayChange(int[] inputArray) {
		int count = 0;

		List<Integer> defaultList = Arrays.stream(inputArray).boxed().collect(Collectors.toList());
		List<Integer> tempList = Arrays.stream(inputArray).boxed().collect(Collectors.toList());

		for (int i = 0, j = i + 1; i < defaultList.size() && j < defaultList.size(); i++, j++) {
			int current = tempList.get(i);
			int next = tempList.get(j);
			int newValue = 0;

			if (next < current) {
				int range = Math.abs(current - next) + 1; // increment needed to become next increasing number
				newValue = next + range; // new next number value
				count += range; // count increment needed
				tempList.set(j, newValue);
			} else if (next == current) {
				newValue = current + 1;
				count++;
				tempList.set(j, newValue);
			}
		}

//		System.out.println(defaultList);
//		System.out.println(tempList);

		return count;
	}
}
