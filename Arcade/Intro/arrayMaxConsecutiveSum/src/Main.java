public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		int[] a = new int[]{};
		int k = 0;
		System.out.println(main.arrayMaxConsecutiveSum(a, k));
	}

	int arrayMaxConsecutiveSum(int[] inputArray, int k) {
		int result = 0;
		int max = 0;

		for (int i = 0; i < inputArray.length; i++) {
			int sum = 0;
			for (int j = i; j < i + k && j < inputArray.length; j++) {
				sum += inputArray[j];
			}

			if (sum > max) {
				max = sum;
			}
		}

		result = max;

		return result;
	}
}
