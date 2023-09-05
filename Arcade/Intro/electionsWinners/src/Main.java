import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		int[] a = new int[]{1, 3, 3, 1, 1};
		int b = 0;
		System.out.println(main.electionsWinners(a, b));
	}

	int electionsWinners(int[] votes, int k) {
		int result = 0;

		List<Integer> defaultList = Arrays.stream(votes).boxed().collect(Collectors.toList());
		int max = Collections.max(defaultList);

		int count = 0;

		if (k == 0) {
			for (int i = 0; i < defaultList.size(); i++) {
				if (max == defaultList.get(i)) {
					count++;
				}
			}

			if (count >= 2) {
				return 0;
			} else if (count == 1) {
				return 1;
			}

		} else {
			for (int i = 0; i < defaultList.size(); i++) {
				if (defaultList.get(i) + k > max) {
					count++;
				}
			}

			return count;
		}

		return result;
	}

}
