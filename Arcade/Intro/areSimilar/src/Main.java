import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		int[] a = new int[]{832, 998, 148, 570, 533, 561, 894, 147, 455, 279};
		int[] b = new int[]{832, 998, 148, 570, 533, 561, 455, 147, 894, 279};
		System.out.println(main.areSimilar(a, b));
	}

	boolean areSimilar(int[] a, int[] b) {
		boolean result = false;

		int temp = 0;

		List<Integer> list1 = Arrays.stream(a).boxed().collect(Collectors.toList());
		List<Integer> list2 = Arrays.stream(b).boxed().collect(Collectors.toList());

		Collections.sort(list1);
		Collections.sort(list2);

		if (a.length != b.length) {
			return false;
		}

		if (Arrays.equals(a, b)) {
			return true;
		}

		List<Integer> indexDifferentList = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				indexDifferentList.add(i);
			}
		}

		for (int i = 0, j = i + 1; i < indexDifferentList.size() && j < indexDifferentList.size(); i++, j++) {

			int index1 = indexDifferentList.get(i);
			int index2 = indexDifferentList.get(j);

			list1 = Arrays.stream(a).boxed().collect(Collectors.toList());
//			System.out.println("arr1: " + list1);

			temp = list1.get(index1);
			list1.set(index1, list1.get(index2));
			list1.set(index2, temp);

//			System.out.println("arr1: " + list1);

			int[] ints = list1.stream().mapToInt(m -> m.intValue()).toArray();

			if (Arrays.equals(ints, b)) {
				result = true;
				break;
			}

		}

		return result;
	}
}
