import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();

		int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int b = 3;
		int[] rs = main.extractEachKth(a, b);
		System.out.println(Arrays.toString(rs));
	}

	int[] extractEachKth(int[] inputArray, int k) {

		List<Integer> defaultList = Arrays.stream(inputArray).boxed().collect(Collectors.toList());
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < inputArray.length; i++) {
			if ((i + 1) % k != 0) {
				list.add(defaultList.get(i));
			}
		}

		int[] rs = list.stream().mapToInt(i -> i.intValue()).toArray();

		return rs;
	}
}
