public class Main {

	public static void main(String[] args) {
		// write your code here
		Main main = new Main();
		System.out.println(main.knapsackLight(2, 5, 3, 4, 5));
	}

	int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
		int result = 0;

		if (weight1 > maxW && weight2 > maxW) {
			result = 0;
		} else if (weight1 + weight2 <= maxW) {
			result = value1 + value2;
		} else if (weight1 <= maxW && weight2 <= maxW) {

			if (value1 > value2) {
				result = value1;
			} else {
				result = value2;
			}
		} else if (weight1 <= maxW && weight2 > maxW) {
			result = value1;
		} else if (weight2 <= maxW && weight1 > maxW) {
			result = value2;
		}

		return result;
	}
}
