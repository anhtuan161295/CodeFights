import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		int[] rs = new int[]{50, 60, 60, 45, 70};
		System.out.println(Arrays.toString(main.alternatingSums(rs)));
	}

	int[] alternatingSums(int[] a) {
		int totalWeight1 = 0;
		int totalWeight2 = 0;

		for (int i = 0; i < a.length; i++) {
			if (i % 2 == 0) {
				totalWeight1 += a[i];
			} else {
				totalWeight2 += a[i];
			}
		}

		return new int[]{totalWeight1, totalWeight2};
	}

}
