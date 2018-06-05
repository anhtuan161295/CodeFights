import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		int[] inputArray = new int[]{1, 2, 1};
		int elemToReplace = 1;
		int substitutionElem = 3;
		int[] rs = main.arrayReplace(inputArray, elemToReplace, substitutionElem);
		System.out.println(Arrays.toString(rs));
	}

	int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
		int[] result = null;

		List<Integer> defaultList = Arrays.stream(inputArray).boxed().collect(Collectors.toList());
		List<Integer> tempList = defaultList;

		for (int i = 0; i < defaultList.size(); i++) {
			int num = defaultList.get(i);
			if (num == elemToReplace) {
				tempList.set(i, substitutionElem);
			}
		}

		result = tempList.stream().mapToInt(i -> i.intValue()).toArray();

		return result;
	}
}
