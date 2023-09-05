public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		int[] a = new int[]{-10, -10, -10, -10, -10, -9, -9, -9, -8, -8, -7, -6, -5, -4, -3, -2, -1, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
		System.out.println(main.absoluteValuesSumMinimization(a));
	}

	int absoluteValuesSumMinimization(int[] a) {
		int result = 0;

		int min = a[a.length - 1];
		int x = a[0];

		for (int i = 0; i < a.length; i++) {
			int val = 0;
			for (int j = 0; j < a.length; j++) {
				val += Math.abs(a[j] - a[i]);
			}

			if (i == 0) {
				min = val;
			}

//			System.out.println(val);
			if (val < min) {
				min = val;
				x = a[i];
			}
		}

		result = x;

		return result;
	}
}
